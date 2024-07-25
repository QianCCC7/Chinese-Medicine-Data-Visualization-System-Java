package com.xiaoqian.user.service;

import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.user.domain.dto.LoginUserDto;
import com.xiaoqian.user.domain.vo.LoginUserVo;

public interface LoginService {
    ResponseResult<LoginUserVo> login(LoginUserDto loginUserDto);
}
