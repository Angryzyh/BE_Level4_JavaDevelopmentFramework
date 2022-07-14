package com.angryzyh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.angryzyh.model.User;
import com.angryzyh.service.UserService;
import com.angryzyh.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Angryzyh
* @description 针对表【sbmp_mybatisplus_user】的数据库操作Service实现
* @createDate 2022-07-10 22:13:18
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




