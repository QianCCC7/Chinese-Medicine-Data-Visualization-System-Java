package com.xiaoqian.user.neo4j.repository;

import com.xiaoqian.user.neo4j.nodes.Prescription;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends Neo4jRepository<Prescription, Long> {

}
