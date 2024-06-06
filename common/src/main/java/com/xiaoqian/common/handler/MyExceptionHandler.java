package com.xiaoqian.common.handler;

import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.common.exception.TestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(TestException.class)
    public ResponseResult<Void> test(TestException ex, HttpServletResponse response) {
        log.error("MyExceptionHandler捕捉到登录异常：{}", ex.toString());
        response.setStatus(ex.getCode());
        return ResponseResult.errorResult(ex.getCode(), ex.getMsg());
    }
}
