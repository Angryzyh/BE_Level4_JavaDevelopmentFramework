package com.angryzyh.ioc_annotation.service.impl;

import com.angryzyh.ioc_annotation.model.User;
import com.angryzyh.ioc_annotation.model.UserByValue;
import com.angryzyh.ioc_annotation.dao.UserDao;
import com.angryzyh.ioc_annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplByQualifier implements UserService {

    @Autowired
    @Qualifier(value = "userDaoImpl2")
    private UserDao userDao;

    @Override
    public User userLogin(User user) {
        userDao.userLogin(user);
        System.out.println("service ...");
        return null;
    }

    @Override
    public UserByValue userLogin(UserByValue userByValue) {
        return null;
    }
}
