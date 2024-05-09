package com.xiaoqian.user.neo4j.repository;

import com.xiaoqian.user.neo4j.nodes.Attribution;
import com.xiaoqian.user.neo4j.nodes.Flavor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlavorRepository extends Neo4jRepository<Flavor, Long> {

}
