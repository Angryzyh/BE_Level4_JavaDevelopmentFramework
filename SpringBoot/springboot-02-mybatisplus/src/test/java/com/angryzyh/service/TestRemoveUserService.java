package com.angryzyh.service;

import com.angryzyh.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestRemoveUserService {
    @Autowired
    private User user;
    @Autowired
    private UserService userService;

    @Test
    public void testRemoveUser() {

    }
}
