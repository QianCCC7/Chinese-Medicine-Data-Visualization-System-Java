package com.xiaoqian.user.neo4j.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel("节点分类信息")
public class Categories {
    @ApiModelProperty("节点分类名称")
    private String name;
}
