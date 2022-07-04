package com.angryzyh.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }

    //测试异常处理器
    @RequestMapping("/testHandlerExceptionResolver.do")
    public String toError() {
        int i = 10 / 0;
        return "success";
    }
}
