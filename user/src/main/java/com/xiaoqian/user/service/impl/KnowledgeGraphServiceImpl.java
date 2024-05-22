package com.xiaoqian.user.service.impl;

import com.xiaoqian.common.utils.BeanCopyUtils;
import com.xiaoqian.user.neo4j.dto.SelectedLegendDto;
import com.xiaoqian.user.neo4j.nodes.MedicineHerbs;
import com.xiaoqian.user.neo4j.nodes.Prescription;
import com.xiaoqian.user.neo4j.relations.MedicineHerbsAndPrescriptionRelation;
import com.xiaoqian.user.neo4j.repository.MedicineHerbsAndPrescriptionRelationRepository;
import com.xiaoqian.user.neo4j.repository.MedicineHerbsRepository;
import com.xiaoqian.user.neo4j.repository.PrescriptionRepository;
import com.xiaoqian.user.neo4j.vo.Categories;
import com.xiaoqian.user.neo4j.vo.Node;
import com.xiaoqian.user.neo4j.vo.Relation;
import com.xiaoqian.user.neo4j.vo.ResultVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class KnowledgeGraphServiceImpl {
    private final MedicineHerbsRepository medicineHerbsRepository;
    private final PrescriptionRepository prescriptionRepository;
    private final MedicineHerbsAndPrescriptionRelationRepository medicineHerbsAndPrescriptionRelationRepository;

    // 初始化关系图，初始只展示方剂的第一个分类下的节点以及和这些有关系的药材节点
    public ResultVo initGraph() {
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
        Set<Categories> medicineHerbsCategory = new HashSet<>(); // 药材分类
        TreeSet<Categories> prescriptionCategory = new TreeSet<>(Comparator.comparing(Categories::getName)); // 方剂分类
        // 5. 填充响应结果
        // 5.1 初始化分类数据
        for (MedicineHerbs medicineHerbs : medicineHerbsIterable) {
            medicineHerbsCategory.add(new Categories(medicineHerbs.getCategory()));
        }
        for (Prescription prescription : prescriptionIterable) {
            prescriptionCategory.add(new Categories(prescription.getCategory()));
        }
        // 5.2 获取到方剂分类下的第一个分类名称
        String firstPrescriptionCategory = prescriptionCategory.first().getName();
        // 5.3 初始化边以及节点数据
        for (MedicineHerbsAndPrescriptionRelation relation : medicineHerbsAndPrescriptionRelationIterable) {
            Prescription start = relation.getStart();
            MedicineHerbs end = relation.getEnd();

            relationList.add(new Relation(start.getName(), end.getName(), "来源于"));
            if (start.getCategory().equals(firstPrescriptionCategory)) {
                nodeList.add(new Node(start.getName(), 80, start.getCategory()));
                nodeList.add(new Node(end.getName(), 80, end.getCategory()));
            }
        }

        return new ResultVo(nodeList, relationList, medicineHerbsCategory, prescriptionCategory);
    }


    public Set<Node> changeDisplayedNodes(SelectedLegendDto selectedLegendDto) {
        // 1. 获取当前图例的展示情况
        Map<String, Boolean> selected = selectedLegendDto.getSelected();
        // 2. 定义需要展示的药材和方剂节点集合
        Set<Node> newDisplayedNodes = new HashSet<>();
        for (Map.Entry<String, Boolean> entry : selected.entrySet()) {
            // 为 true说明需要展示对应分类下的节点
            if (entry.getValue().equals(Boolean.TRUE)) {
                String categoryName = entry.getKey();
                // 3. 获取到与当前分类下方剂节点存在关系的所有药材节点
                Set<MedicineHerbs> medicineHerbsSet =
                        medicineHerbsAndPrescriptionRelationRepository.getNodesByCategoryName(categoryName);
                for (MedicineHerbs medicineHerbs : medicineHerbsSet) {
                    Node node = BeanCopyUtils.copyBean(medicineHerbs, Node.class);
                    node.setSymbolSize(80);
                    newDisplayedNodes.add(node);
                }
                // 4. 获取到当前分类下所有的方剂节点
                Set<Prescription> prescriptionsSet =
                        medicineHerbsAndPrescriptionRelationRepository.getNodesByCategoryName2(categoryName);
                for (Prescription prescription : prescriptionsSet) {
                    Node node = BeanCopyUtils.copyBean(prescription, Node.class);
                    node.setSymbolSize(80);
                    newDisplayedNodes.add(node);
                }
            }
        }
        return newDisplayedNodes;
    }
}
