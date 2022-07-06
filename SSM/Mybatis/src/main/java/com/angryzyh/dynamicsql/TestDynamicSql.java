package com.angryzyh.dynamicsql;

import com.angryzyh.dao.DynamicSqlMapper;
import com.angryzyh.model.Employee;
import com.angryzyh.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//测试动态sql
public class TestDynamicSql {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
    DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

    //1.测试<if>标签
    @Test
    public void testIf() {
        Employee employee = new Employee();
        employee.setEmpSex("男");
        List<Employee> list = mapper.getAllEmpUseIf(employee);
        list.forEach(System.out::println);
    }

    //2.测试<where>标签
    @Test
    public void testWhere() {
        Employee employee = new Employee();
        employee.setEmpSex("男");
        List<Employee> list = mapper.getAllEmpUseWhere(employee);
        list.forEach(System.out::println);
    }

    //3.测试<trim>标签
    @Test
    public void testTrim() {
        Employee employee = new Employee();
        employee.setEmpName("李十一");
        employee.setEmpSex("男");
        employee.setEmpAge(21);
        boolean b = mapper.insertAllEmpUseTrim(employee);
        System.out.println("b = " + b);
    }

    //4.测试<choose>、<when>、<otherwise>  实现单个条件查询 传入多条件匹配有优先级，具体看when的位置
    @Test
    public void testChoose() {
        Employee employee = new Employee();
        employee.setEmpSex("男");
        employee.setEmpName("张三");
        List<Employee> list = mapper.getEmpUseChoose(employee);
        list.forEach(System.out::println);
    }

    //5.<foreach>标签实现批量添加
    @Test
    public void testForeach() {
        ArrayList<Employee> list = new ArrayList<>();
        Employee employee1 = new Employee("憨憨", 11, "女", "123@qq.com");
        Employee employee2 = new Employee("憨憨", 11, "女", "123@qq.com");
        Employee employee3 = new Employee("憨憨", 11, "女", "123@qq.com");
        Collections.addAll(list, employee1, employee2, employee3);
        int result = mapper.insertEmpUseForeach(list);
        System.out.println(result);
    }

    //6.<foreach>标签 实现批量删除
    @Test
    public void testDelete() {
        Integer[] array = new Integer[]{12, 13};
        int result = mapper.deleteEmpUseForeach(array);
        System.out.println("result = " + result);
    }

    //7.<sql>标签 <include>标签导入sql片段 查询全部员工信息
    @Test
    public void testSqlAndInclude() {
        System.out.println("sqlSession = " + sqlSession);
        List<Employee> employeeList = mapper.getEmpUseSqlAndInclude();
        employeeList.forEach(System.out::println);
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        System.out.println("sqlSession = " + sqlSession1);
        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        System.out.println("sqlSession2 = " + sqlSession2);
    }
}
