package com.xiaoqian.common.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("分页参数信息")
public class PageQuery {
    public static final Integer DEFAULT_PAGE_NUM = 1;
    public static final Integer DEFAULT_PAGE_SIZE = 20;

    @ApiModelProperty("当前页码")
    private Integer pageNum = DEFAULT_PAGE_NUM;

    @ApiModelProperty("每页显示条数")
    private Integer pageSize = DEFAULT_PAGE_SIZE;
}
