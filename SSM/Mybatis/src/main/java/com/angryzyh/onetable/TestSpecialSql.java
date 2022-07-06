package com.angryzyh.onetable;

import com.angryzyh.dao.UserMapper;
import com.angryzyh.model.User;
import com.angryzyh.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestSpecialSql {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    //1.模糊查询
    @Test
    public void testGetUserByLikeName() {
        List<User> userList = mapper.getUserByLikeName("王");
        System.out.println("userList = " + userList);
    }

    //2.批量删除
    @Test
    public void testBatchDeleteUserById() {
        int i = mapper.batchDeleteUserById("5,6,7");
        sqlSession.commit();
        System.out.println("i = " + i);
    }

    //3.动态设置表名
    @Test
    public void testGetUserByTable() {
        List<User> userList = mapper.getUserByTable("ssm_mybatis_user");
        System.out.println("userList = " + userList);
        /*永远牢记能复制就别手敲*/
        boolean b = "sss_mybatis_user".equals("ssm_mybatis_user");
        System.out.println("b = " + b);
    }

    //4.添加功能获取自增的主键
    @Test
    public void InsertUserByAutoGetId() {
        User user = new User("小刘", "111", 12, "女", "111@qq.com");
        mapper.insertUserByAutoGetId(user);
        sqlSession.commit();
        System.out.println("user = " + user);
    }

}
