package com.xiaoqian.user.controller;


import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.common.query.PageQuery;
import com.xiaoqian.common.query.PageVo;
import com.xiaoqian.user.domain.vo.MedicineHerbsVo;
import com.xiaoqian.user.service.IMedicineHerbsService;
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
@RequestMapping("/medicine-herbs")
@RequiredArgsConstructor
@Api("中医药材相关接口")
public class MedicineHerbsController {
    private final IMedicineHerbsService medicineHerbsService;

    @ApiOperation("获取所有的中医药材数据列表")
    @GetMapping("/all")
    public ResponseResult<List<MedicineHerbsVo>> getAllMedicineHerbs() {
        return medicineHerbsService.getAllMedicineHerbs();
    }

    @ApiOperation("分页查询中医药材数据")
    @GetMapping("/page")
    public ResponseResult<PageVo<MedicineHerbsVo>> getMedicineHerbsPage(PageQuery pageQuery) {
        return medicineHerbsService.getMedicineHerbsPage(pageQuery);
    }

}
