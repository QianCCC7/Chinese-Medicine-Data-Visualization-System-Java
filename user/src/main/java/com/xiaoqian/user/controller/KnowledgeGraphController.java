package com.xiaoqian.user.controller;

import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.common.enums.HttpCodeEnum;
import com.xiaoqian.common.exception.TestException;
import com.xiaoqian.user.neo4j.dto.SelectedLegendDto;
import com.xiaoqian.user.neo4j.vo.Node;
import com.xiaoqian.user.neo4j.vo.ResultVo;
import com.xiaoqian.user.service.impl.KnowledgeGraphServiceImpl;
import lombok.Getter;
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

    @GetMapping("/test")
    public ResponseResult<Void> test() {
        throw new TestException(HttpCodeEnum.ERROR);
    }
}
