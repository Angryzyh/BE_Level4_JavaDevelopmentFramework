package com.angryzyh.ioc_annotation.service;

import com.angryzyh.ioc_annotation.model.User;
import com.angryzyh.ioc_annotation.model.UserByValue;

public interface UserService {
    public User userLogin(User user);
    public UserByValue userLogin(UserByValue userByValue);

}
