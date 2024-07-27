package com.xiaoqian.common.exception;

import com.xiaoqian.common.enums.HttpCodeEnum;

public class LoginException extends BaseException{
    public LoginException(HttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum);
    }
}
