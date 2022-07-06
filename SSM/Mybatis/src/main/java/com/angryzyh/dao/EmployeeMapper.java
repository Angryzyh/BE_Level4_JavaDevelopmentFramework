package com.angryzyh.dao;

import com.angryzyh.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    //*************************************
    //*TestResultMap.java 测试resultMap映射**
    //*************************************
    //查询全部部门员工
    List<Employee> getAllEmp();

    //*********************************
    //*TestManyToOne.java 测试多对一映射**
    //*********************************
    //1.级联操作,查询全部员工,关联到每个人的所在部门
    List<Employee> getAllEmpWithDeptUseCascade();

    //2.使用association处理映射关系,查询全部员工,关联到每个人的所在部门
    List<Employee> getAllEmpWithDeptUseAssociation();

    //3.使用分布查询，查询全部员工,关联到每个人的所在部门
    //3.1 先查询员工
    List<Employee> getAllEmpWithDept();

    //******************************************
    //*TestOneToMany.java 关联这里测试一对多映射1.2*
    //******************************************
    // 分布查询 第二部
    List<Employee> getAllEmpWithDeptByDeptId(@Param("dId") Integer deptId);

}
