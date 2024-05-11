package com.xiaoqian.user.controller;

import com.xiaoqian.user.neo4j.nodes.Medicine;
import com.xiaoqian.user.neo4j.nodes.Provinces;
import com.xiaoqian.user.neo4j.repository.MedicineAndProvincesRelationRepository;
import com.xiaoqian.user.neo4j.repository.MedicineRepository;
import com.xiaoqian.user.neo4j.vo.Categories;
import com.xiaoqian.user.neo4j.vo.Node;
import com.xiaoqian.user.neo4j.vo.Relation;
import com.xiaoqian.user.neo4j.vo.ResultVo;
import com.xiaoqian.user.relations.MedicineAndProvincesRelation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final MedicineRepository medicineRepository;
    private final MedicineAndProvincesRelationRepository medicineAndProvincesRelationRepository;

    @GetMapping("/test")
    public ResultVo test() {
        Iterable<Medicine> all = medicineRepository.findAll();
        Set<Node> nodeList = new HashSet<>();
        List<Relation> relationList = new ArrayList<>();
        Set<Categories> categories = new HashSet<>();
        for (Medicine medicine : all) {
            String name = medicine.getName();
            int size = 80;
            nodeList.add(new Node(medicine.getName(), size, medicine.getCategory()));
            categories.add(new Categories(medicine.getCategory()));


            Optional<List<MedicineAndProvincesRelation>> medicineAndProvincesRelations =
                    medicineAndProvincesRelationRepository.queryMedicineAndProvincesRelationByName(name);
            List<MedicineAndProvincesRelation> relations = medicineAndProvincesRelations.orElse(Collections.emptyList());
            for (MedicineAndProvincesRelation relation : relations) {
                Relation r = new Relation(relation.getStart().getName(), relation.getEnd().getName(), "来源");
                relationList.add(r);
                Provinces end = relation.getEnd();
                nodeList.add(new Node(end.getName(), size, end.getCategory()));
                categories.add(new Categories(end.getCategory()));
            }
        }
        return new ResultVo(nodeList, relationList, categories);
    }
}
