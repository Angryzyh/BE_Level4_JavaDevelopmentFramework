package com.angryzyh.service.impl;

import com.angryzyh.mapper.UserMapper;
import com.angryzyh.model.User;
import com.angryzyh.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
