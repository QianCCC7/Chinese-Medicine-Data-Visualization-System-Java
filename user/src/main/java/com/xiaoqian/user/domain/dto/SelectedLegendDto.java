package com.xiaoqian.user.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

@Data
@ApiModel("知识图谱选中的图例(方剂分类)信息")
public class SelectedLegendDto {
    @ApiModelProperty("键值对,key代表图例(分类)名称,value代表是否被选中")
    private Map<String, Boolean> selected;
}
