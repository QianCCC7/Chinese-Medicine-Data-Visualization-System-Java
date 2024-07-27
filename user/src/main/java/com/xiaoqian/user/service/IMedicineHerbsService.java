package com.xiaoqian.user.service;

import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.common.query.PageQuery;
import com.xiaoqian.common.query.PageVo;
import com.xiaoqian.user.domain.pojo.MedicineHerbs;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqian.user.domain.vo.MedicineHerbsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaoqian
 * @since 2024-05-15
 */
public interface IMedicineHerbsService extends IService<MedicineHerbs> {

    /**
     * 获取所有的中医药材数据列表
     */
    ResponseResult<List<MedicineHerbsVo>> getAllMedicineHerbs();

    /**
     * 分页查询中医药材数据
     */
    ResponseResult<PageVo<MedicineHerbsVo>> getMedicineHerbsPage(PageQuery pageQuery);
}
