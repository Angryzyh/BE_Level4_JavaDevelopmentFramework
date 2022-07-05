package com.angryzyh;

import com.angryzyh.dao.UserMapper;
import com.angryzyh.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class TestDemo {
    InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory SqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
    SqlSession sqlSession = SqlSessionFactory.openSession(true);
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    //测试添加
    @Test
    public void testInsertUser() {
        int i = mapper.insertUser();
        System.out.println("i = " + i);
    }

    //测试查询
    @Test
    public void testGetAllUser() {
        List<User> allUser = mapper.getAllUser();
        for (User user : allUser) {
            System.out.println("user = " + user);
        }
    }
}
