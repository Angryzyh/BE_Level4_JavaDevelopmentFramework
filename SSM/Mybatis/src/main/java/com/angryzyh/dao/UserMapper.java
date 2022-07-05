package com.angryzyh.dao;

import com.angryzyh.model.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //***************
    //*TestDemo.java*
    //***************
    int insertUser();
    List<User> getAllUser();

    //***********************
    //*TestSqlGetParams.java*
    //***********************
    //1.1测试${}字符拼接,单个参数填入sql
    User getUserById1(Integer id);
    //1.2测试#{}占位符,单个参数填入sql
    User getUserById2(Integer id);
    //2.测试多个参数,填入sql
    User checkLogin(String username, String password);
    //3.测试多个参数用map集合封装,填入sql
    User checkLoginByMap(Map<String, Object> map);
    //4.测试实体类封装填入sql
    int insertUserByPOJO(User user);
    //5.测试@param注解将形参,填入sql的{}处
    User checkLoginByAtParam(@Param("username") String username, @Param("password") String password);

    //*******************
    //*TestQuerySql.java*
    //*******************
    //1.查询一个实体类对象,返回值为User
    //2.查询全部实体类对象,返回值为List<User>
    //3.count聚合函数查询
    int getUserCount();
    //4.查询一条数据为map集合
    Map<String, Object> getUserIntoMap(@Param("id") int id);
    //5.1 查询多条数据为map集合, 返回值为list集合内嵌套map元素
    List<Map<String, Object>> getAllUserIntoListMap();
    //5.2 查询多条数据为map集合, 方法上使用@mapkey注解绑定唯一参数
    @MapKey("user_id")
    Map<String, Object> getAllUserIntoMapKey();

    //*********************
    //*TestSpecialSql.java*
    //*********************
    //1.模糊查询
    List<User> getUserByLikeName(@Param("username") String username);
    //2.批量删除
    int batchDeleteUserById(@Param("ids") String userId);
    //3.动态设置表名
    List<User> getUserByTable(@Param("tableName") String tableName);
    //4.添加功能获取自增的主键
    void insertUserByAutoGetId(User user);
}

