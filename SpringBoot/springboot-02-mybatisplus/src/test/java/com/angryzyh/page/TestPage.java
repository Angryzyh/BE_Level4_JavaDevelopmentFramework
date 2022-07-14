package com.angryzyh.page;

import com.angryzyh.mapper.UserMapper;
import com.angryzyh.model.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestPage {

    @Autowired
    private UserMapper userMapper;

    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    //测试 分页
    @Test
    public void testPage1() {
        Page<User> page = new Page<>(2,3);
        lambdaQueryWrapper.select(User::getName, User::getAge)
                .gt(User::getAge, 20)
                .lt(User::getAge, 40);
        Page<User> userPage = userMapper.selectPage(page, lambdaQueryWrapper);
        System.out.println(userPage.getRecords());
        System.out.println(userPage.getPages());
    }

    //测试 自定义分页
    @Test
    public void testPage2() {
        Page<User> page = new Page<>(2,3);
        Page<User> userPage = userMapper.selectMyPage(page, 60);
        userPage.getRecords().forEach(System.out::println);
    }
}
