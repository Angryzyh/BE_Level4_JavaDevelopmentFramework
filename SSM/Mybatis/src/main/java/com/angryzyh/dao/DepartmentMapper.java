package com.angryzyh.dao;

import com.angryzyh.model.Department;
import com.angryzyh.twotable.TestOneToMany;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {

    //******************************************
    //*TestManyToOne.java 关联这里测试多对一映射3.2*
    //******************************************
    //3.2 多对一，分布查询，第二步，查询部门信息
    Department getEmpWithDept(@Param("did") Integer deptId);

    //********************************
    //*TestOneToMany.java 测试一对多映射*
    //********************************
    //1.1 一对多，分布查询，第一步，查询部门下的员工信息，一个部门会查出多个员工信息
    List<Department> getDeptWithEmps();

    //2. 一对多，collection标签 嵌套查询
    List<Department> getDeptWithEmpByCollection(@Param("deptId") Integer deptId);
}
