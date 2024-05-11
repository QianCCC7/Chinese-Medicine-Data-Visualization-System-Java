package com.xiaoqian.user.neo4j.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Node {
    private String name;
    private Integer symbolSize;
    private String category;
}
