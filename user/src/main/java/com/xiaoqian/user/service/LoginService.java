package com.xiaoqian.user.service;

import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.user.domain.dto.LoginUserDto;
import com.xiaoqian.user.domain.dto.RegisterUserDto;
import com.xiaoqian.user.domain.vo.LoginUserVo;

public interface LoginService {
    /**
     * 用户登录
     */
    ResponseResult<LoginUserVo> login(LoginUserDto loginUserDto);

    /**
     * 用户注册
     */
    ResponseResult<Void> register(RegisterUserDto registerUserDto);
}
