package com.xiaoqian.user.neo4j.relations;

import com.xiaoqian.user.neo4j.nodes.Medicine;
import com.xiaoqian.user.neo4j.nodes.Target;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@RelationshipEntity(type = "归经")
public class MedicineAndTargetRelation {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private Medicine start;
    @EndNode
    private Target end;

    MedicineAndTargetRelation(Medicine start, Target end) {
        this.start = start;
        this.end = end;
    }
}
