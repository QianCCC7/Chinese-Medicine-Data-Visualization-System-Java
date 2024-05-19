package com.xiaoqian.user.neo4j.repository;

import com.xiaoqian.user.neo4j.relations.MedicineHerbsAndPrescriptionRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineHerbsAndPrescriptionRelationRepository extends Neo4jRepository<MedicineHerbsAndPrescriptionRelation, Long> {

}
