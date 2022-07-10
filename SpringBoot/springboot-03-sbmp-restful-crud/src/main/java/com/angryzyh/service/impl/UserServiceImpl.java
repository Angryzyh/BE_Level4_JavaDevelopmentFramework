package com.angryzyh.service.impl;

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
    @Autowired
    private User user;

    @Override
    public Page<User> myPage(int currentPage, int pageSize) {
        Page<User> userPage = new Page<>(currentPage, pageSize);
        return userMapper.selectPage(userPage, null);
    }

}




