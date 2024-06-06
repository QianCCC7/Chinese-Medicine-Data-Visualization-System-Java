package com.xiaoqian.user;

import com.xiaoqian.user.neo4j.nodes.MedicineHerbs;
import com.xiaoqian.user.neo4j.nodes.Prescription;
import com.xiaoqian.user.neo4j.relations.MedicineHerbsAndPrescriptionRelation;
import com.xiaoqian.user.neo4j.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UserApplicationTests {

    @Autowired
    private MedicineHerbsAndPrescriptionRelationRepository medicineHerbsAndPrescriptionRelationRepository;
    @Test
    void testNew() {
//        Iterable<MedicineHerbs> medicineHerbsIterable = medicineHerbsRepository.findAll();
//        for (MedicineHerbs medicineHerbs : medicineHerbsIterable) {
//            log.info("节点为{}", medicineHerbs.getName());
//        }
//        Iterable<Prescription> prescriptionIterable = prescriptionRepository.findAll();
//        for (Prescription prescription : prescriptionIterable) {
//            log.info("节点为{}", prescription.getName());
//        }
        Iterable<MedicineHerbsAndPrescriptionRelation> medicineHerbsAndPrescriptionRelationIterable =
                medicineHerbsAndPrescriptionRelationRepository.findAll();
        for (MedicineHerbsAndPrescriptionRelation r : medicineHerbsAndPrescriptionRelationIterable) {
            Prescription start = r.getStart();
            MedicineHerbs end = r.getEnd();
            log.info("{} -['来源于'] -> {}", start.getName(), end.getName());
        }
    }

}
