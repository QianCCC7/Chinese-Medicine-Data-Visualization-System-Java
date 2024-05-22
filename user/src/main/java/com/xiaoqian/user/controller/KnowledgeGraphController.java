package com.xiaoqian.user.controller;

import com.xiaoqian.user.neo4j.dto.SelectedLegendDto;
import com.xiaoqian.user.neo4j.vo.Node;
import com.xiaoqian.user.neo4j.vo.ResultVo;
import com.xiaoqian.user.service.impl.KnowledgeGraphServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class KnowledgeGraphController {
    private final KnowledgeGraphServiceImpl knowledgeGraphService;

    @GetMapping("/initGraph")
    public ResultVo initGraph() {
        return knowledgeGraphService.initGraph();
    }

    @PostMapping("/changeDisplayedNodes")
    public Set<Node> changeDisplayedNodes(@RequestBody SelectedLegendDto selectedLegendDto) {
        return knowledgeGraphService.changeDisplayedNodes(selectedLegendDto);
    }
}
