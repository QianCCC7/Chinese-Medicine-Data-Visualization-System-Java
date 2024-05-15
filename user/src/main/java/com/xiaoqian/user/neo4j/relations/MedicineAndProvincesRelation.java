package com.xiaoqian.user.neo4j.relations;

import com.xiaoqian.user.neo4j.nodes.Medicine;
import com.xiaoqian.user.neo4j.nodes.Provinces;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@RelationshipEntity(type = "来源")
public class MedicineAndProvincesRelation {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private Medicine start;
    @EndNode
    private Provinces end;

    MedicineAndProvincesRelation(Medicine start, Provinces end) {
        this.start = start;
        this.end = end;
    }
}
