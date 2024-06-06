package com.xiaoqian.common.domain;

import com.xiaoqian.common.enums.HttpCodeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class ResponseResult<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    /**
     * 返回成功且有数据集
     */
    @SuppressWarnings("unused")
    public static <T> ResponseResult<T> okResult(T data) {
        return new ResponseResult<T>().ok(HttpCodeEnum.SUCCESS.getCode(), data, HttpCodeEnum.SUCCESS.getMsg());
    }

    /**
     * 返回成功且数据为空(void类型返回值)
     */
    @SuppressWarnings("unused")
    public static <T> ResponseResult<T> okEmptyResult() {
        return new ResponseResult<T>().ok(HttpCodeEnum.SUCCESS.getCode(), null, HttpCodeEnum.SUCCESS.getMsg());
    }

    /**
     * 返回失败且数据为空
     */
    @SuppressWarnings("unused")
    public static <T> ResponseResult<T> errorResult(HttpCodeEnum httpCodeEnum) {
        return new ResponseResult<T>().error(httpCodeEnum);
    }

    private ResponseResult<T> ok(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        return this;
    }

    private ResponseResult<T> error(HttpCodeEnum httpCodeEnum) {
        this.code = httpCodeEnum.getCode();
        this.msg = httpCodeEnum.getMsg();
        this.data = null;
        return this;
    }
}
