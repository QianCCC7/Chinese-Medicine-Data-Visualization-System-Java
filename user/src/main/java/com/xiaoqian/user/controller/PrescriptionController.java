package com.xiaoqian.user.controller;


import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.common.query.PageQuery;
import com.xiaoqian.common.query.PageVo;
import com.xiaoqian.user.domain.vo.MedicineHerbsVo;
import com.xiaoqian.user.domain.vo.PrescriptionVo;
import com.xiaoqian.user.service.IPrescriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaoqian
 * @since 2024-05-15
 */
@RestController
@RequestMapping("/prescription")
@RequiredArgsConstructor
@Api("中医方剂相关接口")
public class PrescriptionController {
    private final IPrescriptionService prescriptionService;

    @ApiOperation("获取所有的中医药材数据列表")
    @GetMapping
    public ResponseResult<List<PrescriptionVo>> getAllPrescription() {
        return prescriptionService.getAllPrescription();
    }

    @ApiOperation("分页查询中方剂数据")
    @GetMapping("/page")
    public ResponseResult<PageVo<PrescriptionVo>> getPrescriptionPage(PageQuery pageQuery) {
        return prescriptionService.getPrescriptionPage(pageQuery);
    }
}
