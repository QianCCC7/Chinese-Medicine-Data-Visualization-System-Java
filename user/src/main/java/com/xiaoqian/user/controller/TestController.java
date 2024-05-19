package com.xiaoqian.user.controller;

import com.xiaoqian.user.neo4j.nodes.MedicineHerbs;
import com.xiaoqian.user.neo4j.nodes.Prescription;
import com.xiaoqian.user.neo4j.relations.MedicineHerbsAndPrescriptionRelation;
import com.xiaoqian.user.neo4j.repository.*;
import com.xiaoqian.user.neo4j.vo.Categories;
import com.xiaoqian.user.neo4j.vo.Node;
import com.xiaoqian.user.neo4j.vo.Relation;
import com.xiaoqian.user.neo4j.vo.ResultVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final MedicineHerbsRepository medicineHerbsRepository;
    private final PrescriptionRepository prescriptionRepository;
    private final MedicineHerbsAndPrescriptionRelationRepository medicineHerbsAndPrescriptionRelationRepository;

    @GetMapping("/test")
    public ResultVo test() {
        // 1. 找到所有的药材节点
        Iterable<MedicineHerbs> medicineHerbsIterable = medicineHerbsRepository.findAll();
        // 2. 找到所有的方剂节点
        Iterable<Prescription> prescriptionIterable = prescriptionRepository.findAll();
        // 3. 找到所有节点间的关系
        Iterable<MedicineHerbsAndPrescriptionRelation> medicineHerbsAndPrescriptionRelationIterable =
                medicineHerbsAndPrescriptionRelationRepository.findAll();
        // 4. 初始化响应结果
        Set<Node> nodeList = new HashSet<>(); // 节点集合
        List<Relation> relationList = new ArrayList<>(); // 边集合
        Set<Categories> medicineHerbsCategory = new HashSet<>(), prescriptionCategory = new HashSet<>(); // 分类集合
        // 5. 填充响应结果
        // 5.1 初始化节点以及分类数据
        for (MedicineHerbs medicineHerbs : medicineHerbsIterable) {
            nodeList.add(new Node(medicineHerbs.getName(), 80, medicineHerbs.getCategory()));
            medicineHerbsCategory.add(new Categories(medicineHerbs.getCategory()));
        }
        for (Prescription prescription : prescriptionIterable) {
            nodeList.add(new Node(prescription.getName(), 80, prescription.getCategory()));
            prescriptionCategory.add(new Categories(prescription.getCategory()));
        }
        // 5.2 初始化边
        for (MedicineHerbsAndPrescriptionRelation relation : medicineHerbsAndPrescriptionRelationIterable) {
            Prescription start = relation.getStart();
            MedicineHerbs end = relation.getEnd();
            relationList.add(new Relation(start.getName(), end.getName(), "来源于"));
        }

        return new ResultVo(nodeList, relationList, medicineHerbsCategory, prescriptionCategory);
    }
}
