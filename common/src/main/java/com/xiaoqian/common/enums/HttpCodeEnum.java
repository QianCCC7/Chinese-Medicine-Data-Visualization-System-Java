package com.xiaoqian.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum HttpCodeEnum {
    SUCCESS(200,"操作成功"),

    USER_IDENTITY_HAS_EXPIRED(408, "用户身份已过期，请重新登录！"),

    USERNAME_ALREADY_EXISTS(409, "用户名已存在！"),

    UPLOAD_FILE_FAILED(400, "文件上传失败"),
    ;

    private final Integer code;
    private final String msg;
}
