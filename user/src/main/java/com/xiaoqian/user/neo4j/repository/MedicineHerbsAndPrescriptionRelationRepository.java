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

    /**
     * 获取到与当前分类(图例)下方剂节点存在关系的所有药材节点
     */
    @Query("match (m:prescription)-[r:`来源于`]-(n:medicine_herbs) where m.category = {categoryName} return n")
    Set<MedicineHerbs> getMedicineHerbsNodesByPrescriptionCategory(@Param("categoryName") String categoryName);

    /**
     * 获取到当前分类(图例)下所有的方剂节点
     */
    @Query("match (m:prescription)-[r:`来源于`]-(n:medicine_herbs) where m.category = {categoryName} return m")
    Set<Prescription> getPrescriptionNodesByPrescriptionCategory(@Param("categoryName") String categoryName);
}
