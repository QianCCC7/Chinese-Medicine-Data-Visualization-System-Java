package com.xiaoqian.user.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("登录状态信息")
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserVo {

    @Data
    @ApiModel("登录用户信息")
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoginUserInfo {
        @ApiModelProperty("用户id")
        private Integer id;
        @ApiModelProperty("用户名")
        private String username;
        @ApiModelProperty("用户手机号")
        private String phone;
        @ApiModelProperty("用户头像")
        private String avatar;
    }

    @ApiModelProperty("token")
    private String token;
    @ApiModelProperty("登录用户信息")
    private LoginUserInfo loginUserInfo;

}
