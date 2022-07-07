package com.angryzyh.controller;

import com.angryzyh.model.Emp;
import com.angryzyh.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    //查询全部员工
    @GetMapping("/employee")
    public ModelAndView empList(ModelAndView mav) {
        List<Emp> empList = empService.getEmpList();
        mav.addObject("empList", empList);
        mav.setViewName("emp/emp_list");
        return mav;
    }

    //添加单个员工
    @PostMapping("/employee")
    public String addEmp(Emp emp) {
        empService.addEmp(emp);
        return "redirect:/emp/employee";
    }
}
