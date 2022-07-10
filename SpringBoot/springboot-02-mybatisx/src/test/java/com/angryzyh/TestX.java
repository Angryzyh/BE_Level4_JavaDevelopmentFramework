package com.angryzyh;

import com.angryzyh.mapper.UserMapper;
import com.angryzyh.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestX {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        User user = new User();
        user.setName("xxxx");
        int i = userMapper.insertSelective(user);
        System.out.println("i = " + i);
    }
}
