package com.xiaoqian.user.neo4j.repository;

import com.xiaoqian.user.neo4j.relations.MedicineAndAttributionRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineAndAttributionRelationRepository extends Neo4jRepository<MedicineAndAttributionRelation, Long> {

}
