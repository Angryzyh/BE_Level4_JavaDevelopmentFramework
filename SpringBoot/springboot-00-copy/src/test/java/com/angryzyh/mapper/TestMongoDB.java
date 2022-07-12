package com.angryzyh.mapper;

import com.angryzyh.model.User;
import com.angryzyh.model.enums.SexEnum;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
public class TestMongoDB {

    @Test
    public void testMongoDB(@Autowired MongoTemplate mongoTemplate) {
        User user = new User();
        user.setEmail("user@example.com");
        user.setSex(SexEnum.女);
        user.setName("憨憨平");
        user.setId("1434142124124124");
        mongoTemplate.save(user);
        System.out.println("================================================================");
        List<User> userList = mongoTemplate.findAll(User.class);
        System.out.println("userList = " + userList);
        userList.forEach(System.out::println);
    }
}
