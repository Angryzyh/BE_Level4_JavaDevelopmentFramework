package com.angryzyh.service;

import com.angryzyh.model.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;

/**
 * @author Angryzyh
 * @description 针对表【sbmp_mybatisplus_user】的数据库操作Service
 * @createDate 2022-07-10 16:55:02
 */
public interface UserService extends IService<User> {

    //分页
    Page<User> myPage(int currentPage, int pageSize);

    //分页模糊查询
    Page<User> myPage(int currentPage, int pageSize, User user);

    //使用myCache
    User getUserByMyCache(Serializable id);

    //使用spring的Cache  启动类加@EnableCaching注解  ,实现类开启@Cacheable 就行
    User getUserBySpringCache(Serializable id);
}
