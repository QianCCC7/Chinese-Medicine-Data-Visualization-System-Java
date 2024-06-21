package com.xiaoqian.user.neo4j.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Data
@AllArgsConstructor
@ApiModel("知识图谱初始化数据")
public class GraphData {
    @ApiModelProperty("所有的节点数据")
    private Set<Node> nodes;
    @ApiModelProperty("所有的关系数据")
    private List<Relation> relations;
    @ApiModelProperty("所有的药材分类")
    private Set<Categories> medicineHerbsCategory;
    @ApiModelProperty("所有的方剂分类")
    private TreeSet<Categories> prescriptionCategory;
}
