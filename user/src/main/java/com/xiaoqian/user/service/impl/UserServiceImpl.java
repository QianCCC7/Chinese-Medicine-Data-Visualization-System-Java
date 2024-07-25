package com.xiaoqian.user.service.impl;

import com.xiaoqian.user.domain.pojo.User;
import com.xiaoqian.user.mapper.UserMapper;
import com.xiaoqian.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaoqian
 * @since 2024-07-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * 根据用户id查询用户
     */
    @Override
    public User findUserByUsername(String username) {
        return lambdaQuery().eq(User::getUsername, username).one();
    }
}
