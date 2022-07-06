package com.angryzyh.cache;

import com.angryzyh.dao.DynamicSqlMapper;
import com.angryzyh.model.Employee;
import com.angryzyh.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestSecondCache {
    SqlSession sqlSession1 = SqlSessionUtil.getSqlSession(true);
    SqlSession sqlSession2 = SqlSessionUtil.getSqlSession(true);
    DynamicSqlMapper mapper1 = sqlSession1.getMapper(DynamicSqlMapper.class);
    DynamicSqlMapper mapper2 = sqlSession2.getMapper(DynamicSqlMapper.class);
    /*
     * ==>二级缓存:二级缓存是SqlSessionFactory级别，
     * 通过同一个SqlSessionFactory创建的SqlSession查询的结果会被缓存；
     * 此后若再次执行相同的查询语句，结果就会从缓存中获取
     * ==>开启二级缓存的4个步骤:
     * 1.在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
     * 2.配置开启二级缓存 在Mapper.xml 配置文件中添加 <cache/>
     * 3.二级缓存必须在SqlSession关闭或提交之后有效
     * 4.查询的数据所转换的实体类类型必须实现序列化的接口 implements Serializable
     * ==>使二级缓存失效的情况：两次查询之间执行了任意地增删改，会使一级和二级缓存同时失效
     * */

    //测试二级缓存
    @Test
    public void testSecondCache() {
        List<Employee> employeeList1 = mapper1.getEmpUseSqlAndInclude();
        employeeList1.forEach(System.out::println);
        sqlSession1.close();
        System.out.println("******************************************************");
        List<Employee> employeeList2 = mapper2.getEmpUseSqlAndInclude();
        employeeList2.forEach(System.out::println);
    }
}
