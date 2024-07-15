package com.xiaoqian.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.common.query.PageQuery;
import com.xiaoqian.common.query.PageVo;
import com.xiaoqian.common.utils.BeanCopyUtils;
import com.xiaoqian.user.domain.pojo.Prescription;
import com.xiaoqian.user.domain.vo.MedicineHerbsVo;
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

    /**
     * 获取所有的中医药材数据列表
     */
    @Override
    public ResponseResult<List<PrescriptionVo>> getAllPrescription() {
        List<Prescription> prescriptionList = list();
        return ResponseResult.okResult(BeanCopyUtils.copyBeanList(prescriptionList, PrescriptionVo.class));
    }

    /**
     * 分页查询中医方剂数据
     */
    @Override
    public ResponseResult<PageVo<PrescriptionVo>> getPrescriptionPage(PageQuery pageQuery) {
        // 1. 封装分页参数
        Page<Prescription> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        page.setOptimizeCountSql(false);
        // 2. 分页查询
        page(page);
        // 3. 获取查询数据
        List<Prescription> records = page.getRecords();
        // 4. vo转换
        List<PrescriptionVo> prescriptionVoList = BeanCopyUtils.copyBeanList(records, PrescriptionVo.class);
        // 5. 获取总记录数以及总页数
        long totalRecords = page.getTotal(), totalPages = page.getPages();
        return ResponseResult.okResult(new PageVo<>(prescriptionVoList, totalPages, totalRecords));
    }
}
