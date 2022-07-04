package com.angryzyh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/testError.do")
    public String testError() {
        int i = 10 / 0;
        return "redirect:/test/hello";
    }
}
