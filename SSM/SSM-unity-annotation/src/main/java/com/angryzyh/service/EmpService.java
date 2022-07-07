package com.angryzyh.service;

import com.angryzyh.model.Emp;

import java.util.List;

public interface EmpService {
    //添加一个员工
    int addEmp(Emp emp);

    //查询全部员工信息
    List<Emp> getEmpList();
}
