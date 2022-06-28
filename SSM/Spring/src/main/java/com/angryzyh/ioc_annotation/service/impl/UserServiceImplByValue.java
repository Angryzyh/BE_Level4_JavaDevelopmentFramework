package com.angryzyh.ioc_annotation.service.impl;

import com.angryzyh.ioc_annotation.bean.User;
import com.angryzyh.ioc_annotation.bean.UserByValue;
import com.angryzyh.ioc_annotation.dao.UserDao;
import com.angryzyh.ioc_annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplByValue implements UserService {

    @Autowired
    @Qualifier(value = "userDaoImpl")
    private UserDao userDao;

    @Override
    public User userLogin(User user) {
        userDao.userLogin(user);
        System.out.println("service ...");
        return null;
    }

    @Override
    public UserByValue userLogin(UserByValue userByValue) {
        UserByValue userByValue1 = userDao.userLogin(userByValue);
        System.out.println("service ...");
        return userByValue1;
    }
}
