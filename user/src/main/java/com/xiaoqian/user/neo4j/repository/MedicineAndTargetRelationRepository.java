package com.xiaoqian.user.neo4j.repository;

import com.xiaoqian.user.relations.MedicineAndTargetRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineAndTargetRelationRepository extends Neo4jRepository<MedicineAndTargetRelation, Long> {

}
