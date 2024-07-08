package com.xiaoqian.user.domain.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("菜单信息")
public class MenuVo {
    @ApiModelProperty("菜单id")
    private Integer id;

    @ApiModelProperty("菜单名称")
    private String menuName;

    @ApiModelProperty("菜单icon")
    private String menuIcon;

    @ApiModelProperty("菜单渲染的组件")
    private String componentPath;
}
