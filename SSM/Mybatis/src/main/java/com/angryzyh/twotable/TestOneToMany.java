package com.angryzyh.twotable;

import com.angryzyh.dao.DepartmentMapper;
import com.angryzyh.model.Department;
import com.angryzyh.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

//一对多映射处理
public class TestOneToMany {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
    DepartmentMapper mapper = (DepartmentMapper) sqlSession.getMapper(DepartmentMapper.class);
    private Department emp;

    //测试一对多 分布查询
    @Test
    public void testOneToMany() {
        List<Department> departmentList = mapper.getDeptWithEmps();
        /*自己写出来了太抽象，自己看了半天才发现，已经实现效果了，效果自己没看懂而已。*/
      /*  departmentList.forEach(System.out::println);
        departmentList.forEach(dept -> dept.getEmps().forEach(System.out::println));*/

        departmentList.forEach(department -> System.out.println(department.getDeptId() + "" + department.getDeptName() + "" + department.getEmps()));

        /*for (int i = 0; i < departmentList.size(); i++) {
            System.out.println(departmentList.get(i).getDeptId()+departmentList.get(i).getDeptName());
            System.out.println(departmentList.get(i).getEmps());
        }*/
    }

    //测试一对多 collection标签 内联量表关联查询
    @Test
    public void testOneToManyByCollection() {
        List<Department> departmentList = mapper.getDeptWithEmpByCollection(1);
        departmentList.forEach(department -> System.out.println(department.getDeptId()+department.getDeptName()+department.getEmps()));
    }
}
