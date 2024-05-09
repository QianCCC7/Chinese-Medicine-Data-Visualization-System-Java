package com.xiaoqian.user.neo4j.repository;

import com.xiaoqian.user.neo4j.nodes.Provinces;
import com.xiaoqian.user.neo4j.nodes.Target;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetRepository extends Neo4jRepository<Target, Long> {

}
