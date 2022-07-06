package com.angryzyh.twotable;

import com.angryzyh.dao.EmployeeMapper;
import com.angryzyh.model.Employee;
import com.angryzyh.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestResultMap {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
    EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

    //测试根据resultMap查询全部员工信息
    @Test
    public void testGetAllEmp() {
        List<Employee> allEmp = mapper.getAllEmp();
        allEmp.forEach(System.out::println);
    }
}
