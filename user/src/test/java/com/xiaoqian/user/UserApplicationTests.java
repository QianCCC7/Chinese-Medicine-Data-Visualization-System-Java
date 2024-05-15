package com.xiaoqian.user;

import com.xiaoqian.user.neo4j.nodes.Medicine;
import com.xiaoqian.user.neo4j.nodes.Provinces;
import com.xiaoqian.user.neo4j.repository.MedicineAndProvincesRelationRepository;
import com.xiaoqian.user.neo4j.repository.MedicineRepository;
import com.xiaoqian.user.neo4j.relations.MedicineAndProvincesRelation;
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

}
