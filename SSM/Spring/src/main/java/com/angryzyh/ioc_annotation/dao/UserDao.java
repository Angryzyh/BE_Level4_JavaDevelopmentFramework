package com.angryzyh.ioc_annotation.dao;

import com.angryzyh.ioc_annotation.bean.User;
import com.angryzyh.ioc_annotation.bean.UserByValue;

public interface UserDao {
    public User userLogin(User user);
    public UserByValue userLogin(UserByValue userByValue);
}
