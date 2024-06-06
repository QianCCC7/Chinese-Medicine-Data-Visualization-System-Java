package com.xiaoqian.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpCodeEnum {
    SUCCESS(200,"操作成功"),
    ERROR(400,"就做个测试"),
    ;

    private final Integer code;
    private final String msg;
}
