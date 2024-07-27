package com.xiaoqian.common.handler;

import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.common.enums.HttpCodeEnum;
import com.xiaoqian.common.exception.LoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;


@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(LoginException.class)
    public ResponseResult<Void> loginExceptionHandler(LoginException loginException) {
        if (Objects.equals(loginException.getCode(), HttpCodeEnum.USERNAME_ALREADY_EXISTS.getCode())) {
            log.debug("发生了注册异常：{}", loginException.getMsg());
        }

        return ResponseResult.errorResult(loginException.getCode(), loginException.getMsg());
    }
}
