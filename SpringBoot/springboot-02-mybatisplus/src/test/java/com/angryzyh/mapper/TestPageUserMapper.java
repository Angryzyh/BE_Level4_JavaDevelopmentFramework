package com.angryzyh.mapper;

import com.angryzyh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestPageUserMapper {

    @Autowired
    private User user;
    @Autowired
    private UserMapper userMapper;
}
