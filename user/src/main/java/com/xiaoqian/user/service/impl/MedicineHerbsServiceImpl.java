package com.xiaoqian.user.service.impl;

import com.xiaoqian.common.utils.BeanCopyUtils;
import com.xiaoqian.user.domain.pojo.MedicineHerbs;
import com.xiaoqian.user.domain.pojo.Prescription;
import com.xiaoqian.user.domain.vo.MedicineHerbsVo;
import com.xiaoqian.user.domain.vo.PrescriptionVo;
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

    @Override
    public List<MedicineHerbsVo> getAllMedicineHerbs() {
        List<MedicineHerbs> medicineHerbsList = list();
        return BeanCopyUtils.copyBeanList(medicineHerbsList, MedicineHerbsVo.class);
    }
}
