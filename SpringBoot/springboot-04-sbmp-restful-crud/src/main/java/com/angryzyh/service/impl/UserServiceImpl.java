package com.angryzyh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.angryzyh.model.User;
import com.angryzyh.service.UserService;
import com.angryzyh.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Angryzyh
 * @description 针对表【sbmp_mybatisplus_user】的数据库操作Service实现
 * @createDate 2022-07-10 16:55:02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> myPage(int currentPage, int pageSize) {
        Page<User> userPage = new Page<>(currentPage, pageSize);
        return userMapper.selectPage(userPage, null);
    }

    @Override
    public Page<User> myPage(int currentPage, int pageSize, User user) {
        Page<User> userPage = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<User> userQuery = new LambdaQueryWrapper<>();
        userQuery.like(StringUtils.isNotBlank(user.getName()),User::getName, user.getName())
                .like(user.getAge()!=null,User::getAge, user.getAge())
                .like(StringUtils.isNotBlank(user.getEmail()),User::getEmail, user.getEmail())
                .eq(user.getSex()!=null,User::getSex,user.getSex());
        return userMapper.selectPage(userPage, userQuery);
    }
}




