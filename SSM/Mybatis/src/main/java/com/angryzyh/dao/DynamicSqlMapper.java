package com.angryzyh.dao;

import com.angryzyh.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//测试动态sql
public interface DynamicSqlMapper {

    //*************************
    //*TestDynamicSql.java*
    //***********************
    //1. <if>标签  根据if条件获取全部员工信息
    List<Employee> getAllEmpUseIf(Employee employee);

    //2. <where>标签   获取全部员工信息
    List<Employee> getAllEmpUseWhere(Employee employee);

    //3.<trim>标签   插入单个员工
    boolean insertAllEmpUseTrim(Employee employee);

    //4，<choose>、<when>、<otherwise>  嵌套判断  查询员工
    List<Employee> getEmpUseChoose(Employee employee);

    //5.<foreach>标签实现批量添加
    int insertEmpUseForeach(@Param("emps") List<Employee> emps);

    //6.<foreach>标签 实现批量删除
    int deleteEmpUseForeach(@Param("ids") Integer[] ids);

    //7.<sql>标签 <include>标签导入sql片段 查询全部员工信息
    List<Employee> getEmpUseSqlAndInclude();
}
