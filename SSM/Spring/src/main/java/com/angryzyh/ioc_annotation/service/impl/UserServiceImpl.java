package com.angryzyh.ioc_annotation.service.impl;

import com.angryzyh.ioc_annotation.model.User;
import com.angryzyh.ioc_annotation.model.UserByValue;
import com.angryzyh.ioc_annotation.service.UserService;
import com.angryzyh.ioc_annotation.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier(value = "userDaoImpl")
    private UserDao userDao;

    @Override
    public User userLogin(User user) {
        User user1 = userDao.userLogin(user);
        if (user1 != null) {
            System.out.println(user1.getUname()+":登录成功!");
        }
        return null;
    }

    @Override
    public UserByValue userLogin(UserByValue userByValue) {
        return null;
    }
}
