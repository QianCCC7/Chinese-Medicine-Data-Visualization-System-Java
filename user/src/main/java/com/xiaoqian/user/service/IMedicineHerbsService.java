package com.xiaoqian.user.service;

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

    List<MedicineHerbsVo> getAllMedicineHerbs();
}
