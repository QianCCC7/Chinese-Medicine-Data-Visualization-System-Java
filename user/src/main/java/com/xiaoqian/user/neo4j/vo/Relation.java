package com.xiaoqian.user.neo4j.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel("关系信息")
public class Relation {
    @ApiModelProperty("关系源")
    private String source;
    @ApiModelProperty("关系目标")
    private String target;
    @ApiModelProperty("关系值")
    private String value;
}
