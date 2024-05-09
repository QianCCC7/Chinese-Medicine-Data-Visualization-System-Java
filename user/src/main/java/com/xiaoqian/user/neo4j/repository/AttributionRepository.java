package com.xiaoqian.user.neo4j.repository;

import com.xiaoqian.user.neo4j.nodes.Attribution;
import com.xiaoqian.user.neo4j.nodes.Medicine;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributionRepository extends Neo4jRepository<Attribution, Long> {

}
