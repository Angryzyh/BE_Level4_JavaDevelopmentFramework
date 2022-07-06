package com.angryzyh.cache;

import com.angryzyh.dao.DynamicSqlMapper;
import com.angryzyh.model.Employee;
import com.angryzyh.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestFirstCache {
     /*  一级缓存:一级缓存是SqlSession级别的，通过同一个SqlSession查询的数据会被缓存，
        下次查询相同的数据，就会从缓存中直接获取，不会从数据库重新访问
    一级缓存失效的四种情况:
    1. 不同的SqlSession对应不同的一级缓存
    2. 同一个SqlSession但是查询条件不同
    3. 同一个SqlSession两次查询期间执行了任何一次增删改操作
    4. 同一个SqlSession两次查询期间手动清空了缓存*/

    SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
    DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

    //测试一级缓存
    @Test
    public void testFirstCache() {
        List<Employee> employeeList1 = mapper.getEmpUseSqlAndInclude();
        employeeList1.forEach(System.out::println);
        System.out.println("******************************************************");
        List<Employee> employeeList2 = mapper.getEmpUseSqlAndInclude();
        employeeList2.forEach(System.out::println);
    }
}
