package com.angryzyh.mapper;

import com.angryzyh.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;

@SpringBootTest
public class TestInsertUserMapper {

    /*@Autowired
    private User user;*/
    @Autowired
    private UserMapper userMapper;

    //测试添加单个实体类
    @Test
    public void testInsert() {
        for (int i = 1; i < 2; i++) {
            User user = new User();
            user.setName("六六2"+i);
            user.setAge(14+i);
            user.setEmail("14124s"+i+"adj@gmail.com");
            int result = userMapper.insert(user);
            /*System.out.println("result = " + result);
            Long id = user.getId();
            System.out.println("id = " + id);*/
        }
    }

}
