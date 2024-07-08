package com.xiaoqian.user.service.impl;

import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.common.utils.BeanCopyUtils;
import com.xiaoqian.user.domain.pojo.Menu;
import com.xiaoqian.user.domain.vo.MenuVo;
import com.xiaoqian.user.mapper.MenuMapper;
import com.xiaoqian.user.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaoqian
 * @since 2024-07-07
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    /**
     * 获取所有菜单
     */
    @Override
    public ResponseResult<List<MenuVo>> getAllMenus() {
        List<Menu> menuList = list();
        return ResponseResult.okResult(BeanCopyUtils.copyBeanList(menuList, MenuVo.class));
    }
}
