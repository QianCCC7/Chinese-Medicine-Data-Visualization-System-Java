package com.xiaoqian.user.controller;


import com.xiaoqian.user.domain.vo.PrescriptionVo;
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
@RequestMapping("/prescription")
@RequiredArgsConstructor
public class PrescriptionController {
    private final IPrescriptionService prescriptionService;

    @GetMapping
    public List<PrescriptionVo> getAllPrescription() {
        return prescriptionService.getAllPrescription();
    }
}
