package com.angryzyh.onetable;

import com.angryzyh.dao.UserMapper;
import com.angryzyh.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestQuerySql {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    //1.测试查询一个实体类对象,返回值为User
    //2.测试查询全部实体类对象,返回值为List<User>

    //3.count聚合函数查询
    @Test
    public void testGetUserCount() {
        int userCount = mapper.getUserCount();
        System.out.println("userCount = " + userCount);
    }

    //4.查询一条数据为map集合
    @Test
    public void testGetUserIntoMap() {
        Map<String, Object> map = mapper.getUserIntoMap(1);
        System.out.println("map = " + map);
        map.forEach((key,value)-> System.out.println((key+"==="+value)));
        //map = {user_sex=男, user_password=1234556, user_email=1231@qq.com, user_id=1, user_name=小米, user_age=41}
    }

    //5.1 查询多条数据为map集合, 返回值为list集合内嵌套map元素
    @Test
    public void testGetAllUserIntoListMap() {
        List<Map<String, Object>> listMap = mapper.getAllUserIntoListMap();
        listMap.forEach(System.out::println);
      /*  for (Map<String, Object> map : listMap) {
            System.out.println("map = " + map);
        }*/
    }

    //5.2 查询多条数据为map集合, 方法上使用@mapkey注解绑定唯一参数
    @Test
    public void testGetAllUserIntoMapKey() {
        Map<String, Object> m = mapper.getAllUserIntoMapKey();
        System.out.println("m = " + m);
        System.out.println("迭代器遍历");
        //迭代器
        Iterator<Map.Entry<String, Object>> iterable = m.entrySet().iterator();
        iterable.forEachRemaining(System.out::println);
       /* while (iterable.hasNext()) {
            System.out.println(iterable.next());
        }*/

        //增强fot
        /*for (Map.Entry<String, Object> stringObjectEntry : m.entrySet()) {
            System.out.println(stringObjectEntry);
        }*/
    }


}
