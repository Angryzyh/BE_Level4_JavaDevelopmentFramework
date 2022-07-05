package com.angryzyh.ioc_annotation.dao;

import com.angryzyh.ioc_annotation.model.User;
import com.angryzyh.ioc_annotation.model.UserByValue;

public interface UserDao {
    public User userLogin(User user);
    public UserByValue userLogin(UserByValue userByValue);
}
