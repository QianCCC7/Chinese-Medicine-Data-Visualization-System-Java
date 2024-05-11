package com.xiaoqian.user.neo4j.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Relation {
    private String source;
    private String target;
    private String value;
}
