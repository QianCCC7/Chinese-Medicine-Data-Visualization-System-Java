package com.xiaoqian.user.neo4j.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Data
@AllArgsConstructor
public class GraphData {
    private Set<Node> nodes;
    private List<Relation> relations;
    private Set<Categories> medicineHerbsCategory;
    private TreeSet<Categories> prescriptionCategory;
}
