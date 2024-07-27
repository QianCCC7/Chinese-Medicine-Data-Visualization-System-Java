package com.xiaoqian.user.controller;

import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.user.domain.dto.LoginUserDto;
import com.xiaoqian.user.domain.dto.RegisterUserDto;
import com.xiaoqian.user.domain.vo.LoginUserVo;
import com.xiaoqian.user.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api(tags = "登录相关接口")
public class LoginController {
    private final LoginService loginService;

    @ApiOperation("用户登录")
    @PostMapping("login")
    public ResponseResult<LoginUserVo> login(@RequestBody LoginUserDto loginUserDto) {
        return loginService.login(loginUserDto);
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public ResponseResult<Void> register(@RequestBody RegisterUserDto registerUserDto) {
        return loginService.register(registerUserDto);
    }

}
