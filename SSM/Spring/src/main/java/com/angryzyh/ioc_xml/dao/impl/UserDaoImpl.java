package com.angryzyh.ioc_xml.dao.impl;

import com.angryzyh.ioc_xml.model.User;
import com.angryzyh.ioc_xml.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public User userLogin(User user) {
        System.out.println("从数据库查找到用户："+user);
        return user;
    }
}
