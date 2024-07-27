package com.xiaoqian.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum HttpCodeEnum {
    SUCCESS(200,"操作成功"),


    USERNAME_ALREADY_EXISTS(409, "用户名已存在"),
    ;

    private final Integer code;
    private final String msg;
}
