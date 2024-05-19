package com.xiaoqian.user.neo4j.relations;

import com.xiaoqian.user.neo4j.nodes.MedicineHerbs;
import com.xiaoqian.user.neo4j.nodes.Prescription;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@RelationshipEntity(type = "来源于")
public class MedicineHerbsAndPrescriptionRelation {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private Prescription start;
    @EndNode
    private MedicineHerbs end;

    MedicineHerbsAndPrescriptionRelation(Prescription start, MedicineHerbs end) {
        this.start = start;
        this.end = end;
    }
}
