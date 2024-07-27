package com.xiaoqian.user.service;

import com.xiaoqian.user.domain.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaoqian
 * @since 2024-07-21
 */
public interface IUserService extends IService<User> {

    /**
     * 根据用户名查询用户
     */
    User findUserByUsername(String username);
}
