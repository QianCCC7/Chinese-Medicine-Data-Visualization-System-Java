package com.xiaoqian.common.exception;

import com.xiaoqian.common.enums.HttpCodeEnum;

public class TestException extends BaseException{

    public TestException(HttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum);
    }
}
