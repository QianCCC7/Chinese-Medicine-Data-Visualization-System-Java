package com.xiaoqian.common.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("分页数据信息")
public class PageVo<T> {
    @ApiModelProperty("分页数据记录")
    private List<T> rows;

    @ApiModelProperty("分页数据总页数")
    private Long totalPages;

    @ApiModelProperty("分页数据总记录数")
    private Long totalRecords;
}
