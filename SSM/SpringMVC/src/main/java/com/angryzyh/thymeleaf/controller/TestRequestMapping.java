package com.angryzyh.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestRequestMapping {
    /*测试当类上有请求映射路径时
    前端请求需要把类和方法上的请求映射路径拼接访问
    * */
    @RequestMapping("/TestClassRequestPath.do")
    public String TestClassRequestPath() {
        return "success";
    }

    //测试@RequestMapping的value属性
    @RequestMapping(
            //以下两个请求映射路径都可以请求转发到success页面
            value = {
                    "/TestPropertyValue.do",
                    "/TestPropertyValue2.do"
            }
    )
    public String TestPropertyValue() {
        return "success";
    }

    //测试@RequestMapping的method属性
    @RequestMapping(
            value = {"/TestPropertyMethod.do"},
            //声明请求映射可以匹配的请求方式
            method = {RequestMethod.POST}
    )
    public String TestPropertyMethod() {
        return "success";
    }

    /*
        测试@RequestMapping的派生注解:
        处理get请求的映射-->@GetMapping
        处理post请求的映射-->@PostMapping
        处理put请求的映射-->@PutMapping
        处理patch请求的映射-->@PatchMapping
        处理delete请求的映射-->@DeleteMapping
    */
    @GetMapping("/TestGetMapping.do")
    public String TestGetMapping() {
        return "success";
    }

    @PostMapping("/TestPostMapping.do")
    public String TestPostMapping() {
        return "success";
    }

    @PatchMapping("/TestPatchMapping.do")
    public String TestPatchMapping() {
        return "success";
    }

    //测试@RequestMapping的params属性
    @RequestMapping(
            value = {"/TestPropertyParams.do"},
            method = {RequestMethod.POST, RequestMethod.GET},
            //注意params的四种表达式
            /* "params" 表示请求映射匹配的请求必须携带params参数
            *  "!params" 表示不能携带params参数
            *  "params=value" 表示必须携带params参数且值必须是value
            *  "params!=value" 表示必须携带params参数且值必须不是value
            * */
            //下面表示: 请求中不能有id参数,必须有name参数,必须有pwd参数且值为123,必须有money参数且值不为0
            params = {"!id", "name", "pwd=123", "money!=0"}
    )
    public String TestPropertyParams() {
        return "success";
    }

    //测试@RequestMapping的headers属性
    @RequestMapping(
            /*
            * 参数表达式同params
            * */
            //若当前请求满足@RequestMapping的value和method属性,但是不满足headers属性,页面显示404 not find
            value = {"/TestPropertyHeaders.do"},
            method = {RequestMethod.POST, RequestMethod.GET},
            headers = {
                    "Host=localhost:8081"
            })
    public String TestPropertyHeaders() {
        return "success";
    }

    //测试SpringMVC支持Ant风格的路径
    @RequestMapping(
            /*
            测试SpringMVC支持ant风格的映射路径:测试 空格,*,?,%,=,/,\,&,.,中文字符
            注意: * % / \ 中文字符 访问400错误的请求
            * */
            value = {"/a?a/TestAnt.do",
                    "/b*b/TestAnt.do",
                    "/cc/**/TestAnt.do"
            }
    )
    public String TestAnt() {
        return "success";
    }

    //测试SpringMVC支持restful风格的路径
    @RequestMapping("/TestRestful/{id}/{username}/{password}.do")
    public String TestRestful(@PathVariable("id") Integer id,@PathVariable("username") String username,@PathVariable("password") String password) {
        return "success";
    }
}
