package com.xiaoqian.user.neo4j.repository;

import com.xiaoqian.user.neo4j.nodes.Provinces;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProvincesRepository extends Neo4jRepository<Provinces, Long> {

}
