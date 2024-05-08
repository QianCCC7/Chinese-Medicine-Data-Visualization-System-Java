package com.xiaoqian.user;

import com.xiaoqian.user.neo4j.nodes.Medicine;
import com.xiaoqian.user.neo4j.repository.MedicineRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
