package com.xiaoqian.user;

import com.xiaoqian.user.neo4j.nodes.MedicineHerbs;
import com.xiaoqian.user.neo4j.nodes.Prescription;
import com.xiaoqian.user.neo4j.relations.MedicineHerbsAndPrescriptionRelation;
import com.xiaoqian.user.neo4j.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
class UserApplicationTests {
    @Autowired
    private MedicineRepository medicineRepository;

    @Test
    void contextLoads() {
        Optional<Medicine> op = medicineRepository.findById(75L);
        Medicine medicine = op.orElse(null);
        log.info("medicine = {}", medicine);
    }

    @Test
    void testQuery() {
        Optional<Medicine> op = medicineRepository.queryNodeByName("槟榔");
        Medicine medicine = op.orElse(null);
        log.info("res = {}", medicine);
    }

    @Autowired
    private MedicineAndProvincesRelationRepository medicineAndProvincesRelationRepository;

    @Test
    void testQueryRelation() {
        Optional<List<MedicineAndProvincesRelation>> op =
                medicineAndProvincesRelationRepository.queryMedicineAndProvincesRelationByName("槟榔");
        List<MedicineAndProvincesRelation> medicineAndProvincesRelations = op.orElse(Collections.emptyList());
        for (MedicineAndProvincesRelation medicineAndProvincesRelation : medicineAndProvincesRelations) {
            Medicine start = medicineAndProvincesRelation.getStart();
            Provinces end = medicineAndProvincesRelation.getEnd();
            log.info("{} -['来源'] -> {}", start.getName(), end.getName());
        }
    }

    @Autowired
    private MedicineHerbsRepository medicineHerbsRepository;
    @Autowired
    private PrescriptionRepository prescriptionRepository;
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
