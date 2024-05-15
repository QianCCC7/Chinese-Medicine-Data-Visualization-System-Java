package com.xiaoqian.user.neo4j.relations;

import com.xiaoqian.user.neo4j.nodes.Attribution;
import com.xiaoqian.user.neo4j.nodes.Medicine;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@RelationshipEntity(type = "药性")
public class MedicineAndAttributionRelation {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private Medicine start;
    @EndNode
    private Attribution end;

    MedicineAndAttributionRelation(Medicine start, Attribution end) {
        this.start = start;
        this.end = end;
    }
}
