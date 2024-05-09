package com.xiaoqian.user.neo4j.repository;

import com.xiaoqian.user.neo4j.nodes.Medicine;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicineRepository extends Neo4jRepository<Medicine, Long> {
    @Query(value = "match (n:medicine) where n.name = {name} return n")
    Optional<Medicine> queryNodeByName(@Param("name") String name);
}
