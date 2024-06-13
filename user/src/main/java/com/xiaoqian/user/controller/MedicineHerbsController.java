package com.xiaoqian.user.controller;


import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.user.domain.vo.MedicineHerbsVo;
import com.xiaoqian.user.domain.vo.PrescriptionVo;
import com.xiaoqian.user.service.IMedicineHerbsService;
import com.xiaoqian.user.service.IPrescriptionService;
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
public class MedicineHerbsController {
    private final IMedicineHerbsService medicineHerbsService;

    @GetMapping
    public ResponseResult<List<MedicineHerbsVo>> getAllMedicineHerbs() {
        return medicineHerbsService.getAllMedicineHerbs();
    }
}
