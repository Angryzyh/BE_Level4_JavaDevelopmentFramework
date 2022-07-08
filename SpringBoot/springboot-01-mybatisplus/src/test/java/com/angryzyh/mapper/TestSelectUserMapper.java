package com.angryzyh.mapper;

import com.angryzyh.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestSelectUserMapper {

    @Autowired
    private User user;
    @Autowired
    private UserMapper userMapper;

    //测试根据id单个查询
    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1545399484526104578L);
        System.out.println("user = " + user);
    }

    //根据map集合条件查询
    @Test
    public void testSelectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name","张三");
        List<User> list = userMapper.selectByMap(map);
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectBatchIds() {
        List<Long> list = Arrays.asList(1545399486275129347L, 1545399486463873026L, 1545399486077997057L);
        List<User> list1 = userMapper.selectBatchIds(list);
        list1.forEach(System.out::println);
    }

    //测试查询全部用户
    @Test
    public void testSelectAllUser() {
        List<User> user = userMapper.selectList(null);
        user.forEach(System.out::println);
    }
}
