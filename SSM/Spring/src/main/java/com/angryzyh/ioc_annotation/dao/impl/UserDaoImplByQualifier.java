package com.angryzyh.ioc_annotation.dao.impl;

import com.angryzyh.ioc_annotation.model.User;
import com.angryzyh.ioc_annotation.model.UserByValue;
import com.angryzyh.ioc_annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository(value = "userDaoImpl2")
public class UserDaoImplByQualifier implements UserDao {
    @Override
    public User userLogin(User user) {
        System.out.println("dao ...");
        return null;
    }

    @Override
    public UserByValue userLogin(UserByValue userByValue) {
        System.out.println("dao ...");
        return null;
    }
}
