package com.xiaoqian.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.common.query.PageQuery;
import com.xiaoqian.common.query.PageVo;
import com.xiaoqian.common.utils.BeanCopyUtils;
import com.xiaoqian.user.domain.pojo.MedicineHerbs;
import com.xiaoqian.user.domain.vo.MedicineHerbsVo;
import com.xiaoqian.user.mapper.MedicineHerbsMapper;
import com.xiaoqian.user.service.IMedicineHerbsService;
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
public class MedicineHerbsServiceImpl extends ServiceImpl<MedicineHerbsMapper, MedicineHerbs> implements IMedicineHerbsService {

    /**
     * 获取所有的中医药材数据列表
     */
    @Override
    public ResponseResult<List<MedicineHerbsVo>> getAllMedicineHerbs() {
        List<MedicineHerbs> medicineHerbsList = list();
        return ResponseResult.okResult(BeanCopyUtils.copyBeanList(medicineHerbsList, MedicineHerbsVo.class));
    }

    /**
     * 分页查询中医药材数据
     */
    @Override
    public ResponseResult<PageVo<MedicineHerbsVo>> getMedicineHerbsPage(PageQuery pageQuery) {
        // 1. 封装分页参数
        Page<MedicineHerbs> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        // 2. 分页查询
        page(page);
        // 3. 获取查询数据
        List<MedicineHerbs> records = page.getRecords();
        // 4. vo转换
        List<MedicineHerbsVo> medicineHerbsVoList = BeanCopyUtils.copyBeanList(records, MedicineHerbsVo.class);
        // 5. 获取总记录数以及总页数
        long totalRecords = page.getTotal(), totalPages = page.getPages();
        return ResponseResult.okResult(new PageVo<>(medicineHerbsVoList, totalPages, totalRecords));
    }
}
