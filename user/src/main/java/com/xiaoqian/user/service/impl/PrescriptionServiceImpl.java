package com.xiaoqian.user.service.impl;

import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.common.utils.BeanCopyUtils;
import com.xiaoqian.user.domain.pojo.Prescription;
import com.xiaoqian.user.domain.vo.PrescriptionVo;
import com.xiaoqian.user.mapper.PrescriptionMapper;
import com.xiaoqian.user.service.IPrescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaoqian
 * @since 2024-05-15
 */
@Service
public class PrescriptionServiceImpl extends ServiceImpl<PrescriptionMapper, Prescription> implements IPrescriptionService {

    @Override
    public ResponseResult<List<PrescriptionVo>> getAllPrescription() {
        List<Prescription> prescriptionList = list();
        return ResponseResult.okResult(BeanCopyUtils.copyBeanList(prescriptionList, PrescriptionVo.class));
    }
}
