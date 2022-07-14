package com.angryzyh.enums;

import com.angryzyh.mapper.UserMapper;
import com.angryzyh.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestEnum {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test01() {
        User user = new User();
        user.setName("小虎");
        user.setSex(SexEnum.MALE);
        user.setAge(13);
        user.setEmail("1231@qq.com");
        int result = userMapper.insert(user);
        System.out.println("result = " + result);
    }
}
