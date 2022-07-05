package com.angryzyh.restful.controller;

import com.angryzyh.restful.model.Employee;
import com.angryzyh.restful.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    //跳转到查询全部用户页面
    @GetMapping("/employee")
    public ModelAndView toEmployee(ModelAndView mav) {
        Collection<Employee> employeeList = employeeDao.getAll();
        mav.addObject("employeeList", employeeList);
        mav.setViewName("emp/employee_list");
        return mav;
    }

    //删除单个用户
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emp/employee";
    }

    //跳转到添加用户页面
    @GetMapping("/toAddEmployee")
    public String toAddEmployee() {
        return "emp/employee_add";
    }

    //添加单个用户
    @PostMapping("/employee")
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emp/employee";
    }

    //跳转到修改用户页面
    @GetMapping("/employee/{id}")
    public String updateEmployee(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "emp/employee_update";
    }

    @PutMapping("/employee")
    public String toUpdateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emp/employee";
    }
}
