package com.xiaoqian.user.relations;

import com.xiaoqian.user.neo4j.nodes.Flavor;
import com.xiaoqian.user.neo4j.nodes.Medicine;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@RelationshipEntity(type = "药味")
public class MedicineAndFlavorRelation {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private Medicine start;
    @EndNode
    private Flavor end;

    MedicineAndFlavorRelation(Medicine start, Flavor end) {
        this.start = start;
        this.end = end;
    }
}
