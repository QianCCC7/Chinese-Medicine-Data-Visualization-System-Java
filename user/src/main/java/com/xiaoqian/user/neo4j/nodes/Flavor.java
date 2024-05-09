package com.xiaoqian.user.neo4j.nodes;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.io.Serializable;

@Data
@NodeEntity(value = "flavor")
public class Flavor implements Serializable {
    @Id
    @GeneratedValue  // 设置主键自增
    private Long id;
    @Property
    private String name;
    @Property
    private String category;

    Flavor(String name, String category) {
        this.name = name;
        this.category = category;
    }
}