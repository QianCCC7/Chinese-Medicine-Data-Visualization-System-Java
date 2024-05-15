package com.xiaoqian.user.neo4j.repository;

import com.xiaoqian.user.neo4j.relations.MedicineAndFlavorRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineAndFlavorRelationRepository extends Neo4jRepository<MedicineAndFlavorRelation, Long> {

}
