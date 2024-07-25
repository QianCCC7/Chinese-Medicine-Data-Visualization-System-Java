package com.xiaoqian.user;

import com.xiaoqian.common.utils.JwtUtils;
import com.xiaoqian.user.neo4j.nodes.MedicineHerbs;
import com.xiaoqian.user.neo4j.nodes.Prescription;
import com.xiaoqian.user.neo4j.relations.MedicineHerbsAndPrescriptionRelation;
import com.xiaoqian.user.neo4j.repository.*;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
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

    @Test
    void testJwt() {
        String info = "xiaoqian666";
        String token = JwtUtils.createJWT(info);
        log.info("token = {}", token);
        Claims claims = JwtUtils.parseJWT(token);
        String subject = claims.getSubject();
        log.info("subject = {}", subject); // 存入的 info
        String id = claims.getId();
        log.info("id = {}", id);
        Date expiration = claims.getExpiration();
        log.info("expiration = {}", expiration);
        Date issuedAt = claims.getIssuedAt();
        log.info("issuedAt = {}", issuedAt);
        String issuer = claims.getIssuer();
        log.info("issuer = {}", issuer);

        Claims claims1 = JwtUtils.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkNDk4MThkOTFmNzg0NmFiYmM2ODFmMzg2MGFmMmZlOSIsInN1YiI6InhpYW9xaWFuNjY2IiwiaXNzIjoieGlhb3FpYW4iLCJpYXQiOjE3MjE2NTMwOTQsImV4cCI6MTcyMTczOTQ5NH0.VcX9_dwsInJXBQPtr8OoJUDWNm_RfsdocECWa_KjxU8");
        String subject1 = claims1.getSubject();
        log.info("subject1 = {}", subject1);
    }

    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    void testPasswordEncoder() {
        String password = "xiaoqian666";
        String encode = passwordEncoder.encode(password);
        log.info("password = {}", encode);
    }

}
