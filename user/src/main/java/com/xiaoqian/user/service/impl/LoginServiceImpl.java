package com.xiaoqian.user.service.impl;

import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.common.utils.BeanCopyUtils;
import com.xiaoqian.common.utils.JwtUtils;
import com.xiaoqian.common.constants.RedisLoginUserConstants;
import com.xiaoqian.user.domain.dto.LoginUserDto;
import com.xiaoqian.user.domain.pojo.User;
import com.xiaoqian.user.domain.vo.LoginUserVo;
import com.xiaoqian.user.security.UserDetailsImpl;
import com.xiaoqian.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@SuppressWarnings({"rawtypes", "unchecked"})
public class LoginServiceImpl implements LoginService {
    private final AuthenticationManager authenticationManager;
    private final RedisTemplate redisTemplate;

    /**
     * 用户登录
     */
    @Override
    public ResponseResult<LoginUserVo> login(LoginUserDto loginUserDto) {
        String username = loginUserDto.getUsername(), password = loginUserDto.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(token);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User loginUser = userDetails.getUser();
        Integer userId = loginUser.getId();
        // 1. 生成 token
        String jwt = JwtUtils.createJWT(userId.toString());
        String key = String.format(RedisLoginUserConstants.REDIS_LOGIN_USER_PREFIX, userId);
        // 2. 将 userDetails 存入 redis
        redisTemplate.opsForValue().set(key, userDetails, RedisLoginUserConstants.REDIS_LOGIN_USER_ACTIVE_TIME, TimeUnit.MILLISECONDS);
        // 3. 封装返回
        LoginUserVo loginUserVo = new LoginUserVo(jwt, BeanCopyUtils.copyBean(loginUser, LoginUserVo.LoginUserInfo.class));

        return ResponseResult.okResult(loginUserVo);
    }
}
