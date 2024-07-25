package com.xiaoqian.user.filter;

import com.xiaoqian.common.constants.RedisLoginUserConstants;
import com.xiaoqian.common.utils.JwtUtils;
import com.xiaoqian.user.domain.pojo.User;
import com.xiaoqian.user.security.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings({"rawtypes"})
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {
    private final RedisTemplate redisTemplate;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, RedisTemplate redisTemplate) {
        super(authenticationManager);
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 1. 获取请求头的 token
        String token = request.getHeader("Authorization");
        if (!StringUtils.hasText(token)) {
            // 未携带 token，交给后面的过滤器处理
            chain.doFilter(request, response);
            return;
        }
        // 2. 解析 token
        Claims claims;
        try {
            claims = JwtUtils.parseJWT(token);
        } catch (Exception e) {
            // token过期或者被篡改
            throw new RuntimeException(e);
        }
        String userId = claims.getSubject();
        // 3. redis获取用户数据
        String key = String.format(RedisLoginUserConstants.REDIS_LOGIN_USER_PREFIX, userId);
        UserDetailsImpl userDetails = (UserDetailsImpl) redisTemplate.opsForValue().get(key);
        if (userDetails == null) {
            // 登录过期
            return;
        }
        User user = userDetails.getUser();
        // 4. 存入 SecurityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // 5. 放行
        chain.doFilter(request, response);
    }
}
