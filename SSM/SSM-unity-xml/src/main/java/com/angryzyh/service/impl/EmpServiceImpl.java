package com.angryzyh.service.impl;

import com.angryzyh.mapper.EmpMapper;
import com.angryzyh.model.Emp;
import com.angryzyh.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EmpService")
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public int addEmp(Emp emp) {
        return empMapper.insertSelective(emp);
    }

    @Override
    public List<Emp> getEmpList() {
        return empMapper.selectByExample(null);
    }
}
