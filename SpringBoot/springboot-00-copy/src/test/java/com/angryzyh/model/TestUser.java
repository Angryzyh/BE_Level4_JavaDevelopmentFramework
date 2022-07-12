package com.angryzyh.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUser {

    @Autowired
    private User user;

    //测试自动生成数据
    @Test
    public void test() {
        System.out.println("user = " + user);
    }
}
