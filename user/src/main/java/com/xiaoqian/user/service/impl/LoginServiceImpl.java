package com.xiaoqian.user.service.impl;

import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.common.enums.HttpCodeEnum;
import com.xiaoqian.common.exception.LoginException;
import com.xiaoqian.common.utils.BeanCopyUtils;
import com.xiaoqian.common.utils.JwtUtils;
import com.xiaoqian.common.constants.RedisLoginUserConstants;
import com.xiaoqian.user.domain.dto.LoginUserDto;
import com.xiaoqian.user.domain.dto.RegisterUserDto;
import com.xiaoqian.user.domain.pojo.User;
import com.xiaoqian.user.domain.vo.LoginUserVo;
import com.xiaoqian.user.security.UserDetailsImpl;
import com.xiaoqian.user.service.IUserService;
import com.xiaoqian.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@SuppressWarnings({"rawtypes", "unchecked"})
public class LoginServiceImpl implements LoginService {
    private final AuthenticationManager authenticationManager;
    private final RedisTemplate redisTemplate;
    private final IUserService userService;
    private final PasswordEncoder passwordEncoder;

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

    /**
     * 用户注册
     */
    @Override
    public ResponseResult<Void> register(RegisterUserDto registerUser) {
        // 1. 校验用户名是否存在
        if (checkUserRepeat(registerUser.getUsername())) {
            throw new LoginException(HttpCodeEnum.USERNAME_ALREADY_EXISTS);
        }
        // 2. 密码加密
        registerUser.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        userService.save(BeanCopyUtils.copyBean(registerUser, User.class));
        return ResponseResult.okEmptyResult();
    }

    /**
     * 判断用户名是否存在
     */
    private boolean checkUserRepeat(String username) {
        return userService.lambdaQuery().eq(User::getUsername, username).count() > 0;
    }

    /**
     * 用户注销
     */
    @Override
    public ResponseResult<Void> logout() {
        // 1. 获取当前登录用户
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Integer userId = userDetails.getUser().getId();
        // 2. 删除用户登录信息
        String key = String.format(RedisLoginUserConstants.REDIS_LOGIN_USER_PREFIX, userId);
        redisTemplate.delete(key);
        return ResponseResult.okEmptyResult();
    }
}
