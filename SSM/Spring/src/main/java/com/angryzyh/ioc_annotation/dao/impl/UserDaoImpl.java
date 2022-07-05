package com.angryzyh.ioc_annotation.dao.impl;

import com.angryzyh.ioc_annotation.model.User;
import com.angryzyh.ioc_annotation.model.UserByValue;
import com.angryzyh.ioc_annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User userLogin(User user) {
        System.out.println("从数据库查找到用户："+user);
        return user;
    }

    @Override
    public UserByValue userLogin(UserByValue userByValue) {
        System.out.println("从数据库查找到用户："+userByValue);
        return null;
    }
}
