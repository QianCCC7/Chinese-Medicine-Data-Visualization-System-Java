package com.xiaoqian.user.neo4j.repository;

import com.xiaoqian.user.neo4j.relations.MedicineAndProvincesRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicineAndProvincesRelationRepository extends Neo4jRepository<MedicineAndProvincesRelation, Long> {
    @Query(value = "MATCH (m:medicine)-[r:`来源`]->(n:provinces) WHERE m.name={name} return m,r,n")
    Optional<List<MedicineAndProvincesRelation>> queryMedicineAndProvincesRelationByName(@Param("name") String name);
}
