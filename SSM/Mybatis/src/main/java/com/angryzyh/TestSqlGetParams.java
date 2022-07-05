package com.angryzyh;

import com.angryzyh.dao.UserMapper;
import com.angryzyh.model.User;
import com.angryzyh.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestSqlGetParams {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    //1.1 测试${}字符串拼接
    @Test
    public void testGetUserById1() {
        User user = mapper.getUserById1(1);
        System.out.println("user = " + user);
    }

    //1.2 测试#{}占位符
    @Test
    public void testGetUserById2() {
        User user = mapper.getUserById2(2);
        System.out.println("user = " + user);
    }

    //2. 测试多个参数
    @Test
    public void testCheckLogin() {
        User user = mapper.checkLogin("小王", "123");
        System.out.println("user = " + user);
    }

    //3. 测试多个参数采用map集合封装
    @Test
    public void testCheckLoginByMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "小王");
        map.put("password", "123");
        User user = mapper.checkLoginByMap(map);
        System.out.println("user = " + user);
    }

    //4. 测试多个参数采用POJO封装
    @Test
    public void testInsertUserByPOJO() {
        int result = mapper.insertUserByPOJO(new User("老八", "123", 33, "男", "131@qq.com"));
        sqlSession.commit();
        System.out.println("result = " + result);
    }

    //5. 测试采用@Param注解形参,绑定填入sql{}内
    @Test
    public void testCheckLoginByAtParam() {
        User user = mapper.checkLoginByAtParam("老八", "123");
        System.out.println("user = " + user);
    }
}