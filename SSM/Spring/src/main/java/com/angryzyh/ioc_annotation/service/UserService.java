package com.angryzyh.ioc_annotation.service;

import com.angryzyh.ioc_annotation.bean.User;
import com.angryzyh.ioc_annotation.bean.UserByValue;

public interface UserService {
    public User userLogin(User user);
    public UserByValue userLogin(UserByValue userByValue);

}
