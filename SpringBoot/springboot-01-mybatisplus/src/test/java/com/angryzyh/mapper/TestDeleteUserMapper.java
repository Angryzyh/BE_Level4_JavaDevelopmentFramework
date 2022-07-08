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
public class TestDeleteUserMapper {

    @Autowired
    private User user;
    @Autowired
    private UserMapper userMapper;

    //根据id删除
    @Test
    public void testDeleteById() {
        //通过id删除
        int result = userMapper.deleteById(1545392916946571266L);
        System.out.println("result = " + result);
        //通过实体类删除
        user.setName("小虎");
        int result2 = userMapper.deleteById(user);
        System.out.println("result2 = " + result2);
    }

    //通过map集合条件删除
    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        //      字段名
        map.put("name", "zyh");
        map.put("age", 31);
        map.put("email", "zyh@gmail.com");
        int result = userMapper.deleteByMap(map);
        System.out.println("result = " + result);
    }

    //根据id批量删除
    @Test
    public void testDeleteBatchIds() {
        List<Long> list = Arrays.asList(3123L, 315134L, 2513431L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println("result = " + result);
    }
}
