package com.angryzyh.wrapper;

import com.angryzyh.mapper.UserMapper;
import com.angryzyh.model.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestQueryWrapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private User user;
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();

    //测试wrapper组装查询条件
    //查询用户名包含六,年龄在20到30之间，邮箱信息不为null的用户信息
    @Test
    public void test01() {
        queryWrapper.like("name", "六")
                .between("age", 20, 30)
                .isNotNull("email");
        /*
         * SELECT id,name,age,email,is_delete
         * FROM sbmp_mybatisplus_user
         * WHERE is_delete=0
         * AND (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
         * ==> Parameters: %六%(String), 20(Integer), 30(Integer)
         * */
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    //测试wrapper组装排序条件
    //查询用户信息，按照年龄的降序排序，若年龄相同，则按照id升序排序
    @Test
    public void test02() {
        queryWrapper.orderByDesc("age")
                .orderByAsc("id");
        /*
         * SELECT id,name,age,email,is_delete
         * FROM sbmp_mybatisplus_user
         * WHERE is_delete=false
         * ORDER BY age DESC,id ASC
         * */
        List<Map<String, Object>> mapList = userMapper.selectMaps(queryWrapper);
        mapList.forEach(System.out::println);
    }

    //测试wrapper组装删除条件
    //删除邮箱地址为null的用户信息
    @Test
    public void test03() {
        queryWrapper.isNull("email");
        /*
         * UPDATE sbmp_mybatisplus_user
         * SET is_delete=true
         * WHERE is_delete=false
         * AND (email IS NULL)
         * */
        int result = userMapper.delete(queryWrapper);
        System.out.println("result = " + result);
    }

    //测试wrapper组装修改条件
    //将(年龄大于20 且 用户名中包含有"六")或邮箱为null的用户信息修改
    @Test
    public void test04() {
        queryWrapper.gt("age", 20)
                .like("name", "六")
                .or()
                .isNull("email");
        /*
         * UPDATE sbmp_mybatisplus_user
         * SET name=?
         * WHERE is_delete=false
         * AND (age > ? AND name LIKE ? OR email IS NULL)
         * ==> Parameters: 老八(String), 20(Integer), %六%(String)
         * */
        user.setName("老八");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result = " + result);
    }

    //测试wrapper组装条件  条件的优先级
    //将用户名中包含有"八"并且(年龄大于20或邮箱为ulL)的用户信息修改
    @Test
    public void test05() {
        queryWrapper.like("name", "八")
                .and(q -> q.gt("age", 20).or().isNull("email"));
        /*
         * UPDATE sbmp_mybatisplus_user
         * SET name=?
         * WHERE is_delete=false
         * AND (name LIKE ? AND (age > ? OR email IS NULL))
         * ==> Parameters: 七二(String), %八%(String), 20(Integer)
         * */
        user.setName("七二");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result = " + result);
    }

    //测试wrapper组装select条件  选择查询字段
    //查询用户的用户名，年龄，邮箱信息
    @Test
    public void test06() {
        queryWrapper.select("name", "age", "email");
        /*
        * SELECT name,age,email
        * FROM sbmp_mybatisplus_user
        * WHERE is_delete=false
        * */
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        System.out.println("================================================================================================================================");
        //list封装map可以选择字段查询
        maps.forEach(System.out::println);
        System.out.println("================================================================================================================================");
        //list封装对象 只能全查询,没有选择查询的字段会被赋值为null
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    //测试queryWrapper组装 inSql 子查询
    //子查询d小于等于100的用户信息
    @Test
    public void test07() {
        queryWrapper.select("name", "age")
                .inSql("id", "select id from sbmp_mybatisplus_user where id <100");
        /*
        * SELECT name,age
        * FROM sbmp_mybatisplus_user
        * WHERE is_delete=false
        * AND (id IN (select id from sbmp_mybatisplus_user where id <100))
        * */
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    //测试queryWrapper组装可能不存在的条件
    //模拟 前端用户 随机选择查询
    @Test
    public void test09() {
        String name = "";
        Integer beginAge = 20;
        Integer endAge = 30;
        if (StringUtils.isNotBlank(name)){
            queryWrapper.like("name", name);
        }
        if (beginAge != null) {
            queryWrapper.gt("age", beginAge);
        }
        if (endAge != null) {
            queryWrapper.lt("age", endAge);
        }
        /*
        * SELECT id,name,age,email,is_delete
        * FROM sbmp_mybatisplus_user
        * WHERE is_delete=false
        * AND (age > ? AND age < ?)
        * ==> Parameters: 20(Integer), 30(Integer)
        * */
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    //test09增强版本 添加条件存在判断
    @Test
    public void test10() {
        String name = "";
        Integer beginAge = 20;
        Integer endAge = 30;
        queryWrapper.like(StringUtils.isNotBlank(name), "name", name)
                .gt(beginAge != null, "age", beginAge)
                .lt(endAge != null, "age", endAge);
        /*
        * SELECT id,name,age,email,is_delete
        * FROM sbmp_mybatisplus_user
        * WHERE is_delete=false
        * AND (age > ? AND age < ?)
        * ==> Parameters: 20(Integer), 30(Integer)
        * */
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    //test 10 再增强 lambda表达式 实体类属性映射表示字段
    @Test
    public void test11() {
        String name = "";
        Integer beginAge = 20;
        Integer endAge = 30;
        lambdaQueryWrapper.like(StringUtils.isNotBlank(name), User::getName, name)
                .gt(beginAge != null, User::getAge, beginAge)
                .lt(endAge != null, User::getAge, endAge);
        /*
         * SELECT id,name,age,email,is_delete
         * FROM sbmp_mybatisplus_user
         * WHERE is_delete=false
         * AND (age > ? AND age < ?)
         * ==> Parameters: 20(Integer), 30(Integer)
         * */
        List<Map<String, Object>> maps = userMapper.selectMaps(lambdaQueryWrapper);
        maps.forEach(System.out::println);
    }

}
