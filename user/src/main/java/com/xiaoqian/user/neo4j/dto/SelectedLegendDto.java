package com.xiaoqian.user.neo4j.dto;

import lombok.Data;

import java.util.Map;

@Data
public class SelectedLegendDto {
    private Map<String, Boolean> selected;
}
