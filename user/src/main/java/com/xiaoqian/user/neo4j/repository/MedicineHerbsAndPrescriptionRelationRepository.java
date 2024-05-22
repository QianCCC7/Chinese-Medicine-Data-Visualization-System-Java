package com.xiaoqian.user.neo4j.repository;

import com.xiaoqian.user.neo4j.nodes.MedicineHerbs;
import com.xiaoqian.user.neo4j.nodes.Prescription;
import com.xiaoqian.user.neo4j.relations.MedicineHerbsAndPrescriptionRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MedicineHerbsAndPrescriptionRelationRepository extends Neo4jRepository<MedicineHerbsAndPrescriptionRelation, Long> {

    @Query("match (m:prescription)-[r:`来源于`]-(n:medicine_herbs) where m.category = {categoryName} return n")
    Set<MedicineHerbs> getNodesByCategoryName(@Param("categoryName") String categoryName);

    @Query("match (m:prescription)-[r:`来源于`]-(n:medicine_herbs) where m.category = {categoryName} return m")
    Set<Prescription> getNodesByCategoryName2(@Param("categoryName") String categoryName);
}
