package com.angryzyh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToController {
    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/toAddEmp")
    public String toAddEmp() {
        return "emp/emp_add";
    }
}
