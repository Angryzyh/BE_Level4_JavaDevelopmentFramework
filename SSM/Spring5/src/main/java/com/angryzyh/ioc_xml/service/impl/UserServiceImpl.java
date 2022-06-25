package com.angryzyh.ioc_xml.service.impl;

import com.angryzyh.ioc_xml.bean.User;
import com.angryzyh.ioc_xml.dao.UserDao;
import com.angryzyh.ioc_xml.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User userLogin(User user) {
        User u = userDao.userLogin(user);
        if (u != null) {
            System.out.println("用户:"+user.getUname()+"登陆成功");
        }
        return u;
    }
}
