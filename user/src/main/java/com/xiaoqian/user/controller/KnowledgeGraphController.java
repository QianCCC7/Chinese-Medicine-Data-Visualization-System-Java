package com.xiaoqian.user.controller;

import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.user.domain.dto.SelectedLegendDto;
import com.xiaoqian.user.neo4j.vo.Node;
import com.xiaoqian.user.neo4j.vo.GraphData;
import com.xiaoqian.user.service.impl.KnowledgeGraphServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api("知识图谱相关接口")
public class KnowledgeGraphController {
    private final KnowledgeGraphServiceImpl knowledgeGraphService;

    @ApiOperation("初始化知识图谱")
    @GetMapping("/initGraph")
    public ResponseResult<GraphData> initGraph() {
        return knowledgeGraphService.initGraph();
    }

    @ApiOperation("点击图例时展示所有选中的图例节点")
    @PostMapping("/changeDisplayedNodes")
    public ResponseResult<Set<Node>> changeDisplayedNodes(@RequestBody SelectedLegendDto selectedLegendDto) {
        return knowledgeGraphService.changeDisplayedNodes(selectedLegendDto);
    }
}
