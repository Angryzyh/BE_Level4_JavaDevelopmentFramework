package com.angryzyh.wrapper;

import com.angryzyh.mapper.UserMapper;
import com.angryzyh.model.User;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUpdateWrapper {
    @Autowired
    private UserMapper userMapper;

    UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
    LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();

    //测试 updateWrapper  修改用户信息
    // 同test05  将用户名中包含有"八"并且(年龄大于20或邮箱为ulL)的用户信息修改
    @Test
    public void test08() {
        updateWrapper.like("name", "八")
                .and(x -> x.gt("age", 20).isNull("email"));
        updateWrapper.set("name", "天天").set("age", 77);
        /*
         *UPDATE sbmp_mybatisplus_user
         * SET name=?,age=?
         * WHERE is_delete=false
         * AND (name LIKE ? AND (age > ? AND email IS NULL))
         * ==> Parameters: 天天(String), 77(Integer), %八%(String), 20(Integer)
         * */
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result = " + result);
    }

    //测试lambdaUpdateWrapper
    //同 test08
    @Test
    public void test12() {
        lambdaUpdateWrapper.like(User::getName, "八")
                .and(x -> x.gt(User::getEmail, 20).isNull(User::getEmail));
        lambdaUpdateWrapper.set(User::getName, "天天").set(User::getAge, 77);
        /*
         *UPDATE sbmp_mybatisplus_user
         * SET name=?,age=?
         * WHERE is_delete=false
         * AND (name LIKE ? AND (age > ? AND email IS NULL))
         * ==> Parameters: 天天(String), 77(Integer), %八%(String), 20(Integer)
         * */
        int result = userMapper.update(null, lambdaUpdateWrapper);
        System.out.println("result = " + result);
    }
}
