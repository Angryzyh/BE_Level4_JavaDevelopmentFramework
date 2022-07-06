package com.angryzyh.twotable;

import com.angryzyh.dao.EmployeeMapper;
import com.angryzyh.model.Employee;
import com.angryzyh.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

//多对一映射处理
public class TestManyToOne {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
    EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

    //1. 测试级联操作
    @Test
    public void testGetAllEmpWithDeptUseCascade() {
        List<Employee> employeeList = mapper.getAllEmpWithDeptUseCascade();
        employeeList.forEach(System.out::println);
    }

    //2，测试association标签嵌套内部表
    @Test
    public void testGetAllEmpWithDeptUseAssociation() {
        List<Employee> employeeList = mapper.getAllEmpWithDeptUseAssociation();
        employeeList.forEach(System.out::println);
    }

    //3.测试多对一，分布查询
    @Test
    public void testDistributionQuery() {
        List<Employee> employeeList = mapper.getAllEmpWithDept();
        employeeList.forEach(System.out::println);
        employeeList.forEach(employee -> System.out.println("employee = " + employee.getEmpEmail()));
        employeeList.forEach(employee -> System.out.println("employee = " + employee.getDept().getDeptName()));
    }
}
