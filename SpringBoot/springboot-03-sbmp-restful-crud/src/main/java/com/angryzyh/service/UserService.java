package com.angryzyh.service;

import com.angryzyh.model.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
* @author Angryzyh
* @description 针对表【sbmp_mybatisplus_user】的数据库操作Service
* @createDate 2022-07-10 16:55:02
*/
public interface UserService extends IService<User> {

    Page<User> myPage(int currentPage, int pageSize);

}
