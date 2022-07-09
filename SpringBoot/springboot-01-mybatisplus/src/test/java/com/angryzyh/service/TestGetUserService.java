package com.angryzyh.service;

import com.angryzyh.model.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@SpringBootTest
public class TestGetUserService {
    @Autowired
    private User user;
    @Autowired
    private UserService userService;

    //根据id查询单个对象
    @Test
    public void testGetUser() {
        User id = userService.getById(1545399484526104579L);
        System.out.println("id = " + id);
    }

    //查询全部用户
    @Test
    public void testGetUserList() {
        List<User> userList = userService.getBaseMapper().selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testGetUserBySelect() {
        QueryWrapper<User> query = new QueryWrapper<User>();
        QueryWrapper<User> userQueryWrapper = query.select("name", "email").like("name", "六");
        List<User> list = userService.list(userQueryWrapper);
        list.forEach(System.out::println);
        System.out.println("list = " + list);
        System.out.println("================================================================================================================================");
        List<Map<String, Object>> maps = userService.listMaps(userQueryWrapper);
        System.out.println("集合遍历 一条数据");
        System.out.println("maps = " + maps);
        System.out.println("====================================================================");
        System.out.println("多行对象");
        maps.forEach(System.out::println);
        System.out.println("================================================================================================================================");
        for (Map<String, Object> map : maps) {
            for (Map.Entry<String, Object> s : map.entrySet()) {
                String s1 = s.getKey() +"::"+ s.getValue();
                System.out.println(s1);
                System.out.println("--------------------");
            }
        }
    }

}
