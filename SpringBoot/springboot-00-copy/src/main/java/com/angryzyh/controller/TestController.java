package com.angryzyh.controller;

import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping
    public String toIndex() {
        System.out.println(" = = = = = = =");
        return "is to hard fuck";
    }

}
