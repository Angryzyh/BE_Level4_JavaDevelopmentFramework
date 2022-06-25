package com.angryzyh.dynamic_proxy.dao.impl;

import com.angryzyh.dynamic_proxy.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public int add(int a, int b) {
        System.out.println("结果："+(a+b));
        return a + b;
    }
}
