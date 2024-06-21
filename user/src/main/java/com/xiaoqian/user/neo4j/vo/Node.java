package com.xiaoqian.user.neo4j.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel("节点信息")
public class Node {
    @ApiModelProperty("节点名称")
    private String name;
    @ApiModelProperty("节点大小")
    private Integer symbolSize;
    @ApiModelProperty("节点分类名称")
    private String category;
}
