package com.xiaoqian.user.neo4j.vo;

import lombok.Data;

@Data
public class Relation {
    private String source;
    private String target;
    private String value;
}
