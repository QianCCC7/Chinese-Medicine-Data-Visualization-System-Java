package com.xiaoqian.user.neo4j.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo {
    private Set<Node> nodes;
    private List<Relation> relations;
    private Set<Categories> medicineHerbsCategory;
    private TreeSet<Categories> prescriptionCategory;
}
