package com.angryzyh.mapper;

import com.angryzyh.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUpdateUserMapper {
    @Autowired
    private User user;
    @Autowired
    private UserMapper userMapper;

    //测试通过实体对象的id修改
    @Test
    public void testUpdateById() {
        user.setName("admin");
        user.setAge(51);
        user.setEmail("admin@angryzyh.com");
        user.setId(52355235235L);
        int result = userMapper.updateById(user);
        System.out.println("result = " + result);
    }
}
