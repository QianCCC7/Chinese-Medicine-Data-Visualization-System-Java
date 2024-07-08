package com.xiaoqian.user.service;

import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.user.domain.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqian.user.domain.vo.MenuVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaoqian
 * @since 2024-07-07
 */
public interface IMenuService extends IService<Menu> {

    ResponseResult<List<MenuVo>> getAllMenus();
}
