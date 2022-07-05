package com.angryzyh.thymeleaf.controller;

import com.angryzyh.thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class TestRequestParams {
    //测试Servlet-api获取请求参数
    //将HttpServletRequest作为控制器方法的形参
    //此时HttpServletRequest类型的参数表示封装了当前请求的请求报文的对象
    @RequestMapping("/testServletAPI.do")
    public String testServletAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("TestRequestParams.testServletAPI");
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }

    //测试SpringMVC的DispatcherServlet前端控制器获取请求参数
    @RequestMapping("/testDispatcherServlet.do")
    public String testDispatcherServlet(String username, String password, String[] hobby) {
        System.out.println("TestRequestParams.testDispatcherServlet");
        System.out.println("username = " + username + "password = " + password + "hobby = " + Arrays.toString(hobby));
        return "success";
    }

    //测试当前端name属性名与控制器参数名不一致时@RequestParam注解获取请求参数
    @RequestMapping("/testRequestParam.do")
    public String testRequestParam(
            //该注解的参数名必须要传输,值可以不写,类似@RequestMapping注解的params属性的表达式
            //用get方式删除user_name参数,会报错400
            @RequestParam("user_name") String username,
            //defaultValue 表示在不传值的时候 默认值是123456
            @RequestParam(value = "user_password", defaultValue = "123456") String password,
            //required=false 表示该属性可以不传,不传该属性则为null, name属性和value属性一样
            @RequestParam(name = "user_hobby", required = false) String[] hobby
    ) {
        System.out.println("TestRequestParams.testRequestParam");
        System.out.println("username = " + username + ", password = " + password + ", hobby = " + Arrays.toString(hobby));
        return "success";
    }

    //测试@RequestHeader注解绑定控制器形参,获取请求头信息
    @RequestMapping("/testRequestHeader.do")
    public String testRequestHeader(
            //请求头信息可以不存在        //不存在赋个默认值
            @RequestHeader(value = "Host", required = false, defaultValue = "11") String host) {
        //获取请求头中的host主机信息
        System.out.println("TestRequestParams.testRequestHeader");
        System.out.println("host = " + host);
        return "success";
    }

    //测试@CookieValue注解,获取第一次会话创建的cookie
    @RequestMapping("/testCookieValue.do")
    public String testCookieValue(HttpServletRequest request,
                                  @CookieValue(value = "JSESSIONID", required = false) String JSESSIONID) {
        /*
          两种会话技术:
             客户端:cookie
             服务端:session
             会话技术默认声明周期,浏览器开启到浏览器关闭
             session对象基于cookie,getSession()的时候就创建了一个cookie
          通过第一次创建会话,获取session对象,[请求报文内没有set-cookie]
          并且创建一个cookie,cookie的key是JSESSIONID,value是一个类似uuid
          服务端创建session对象,放到服务器维护的map集合中,key就是cookie的uuid
          之后访问页面,cookie值就会出现在请求报文内
        * */
        HttpSession session = request.getSession();
        System.out.println("TestRequestParams.testCookieValue");
        System.out.println("request = " + request + ", JSESSIONID = " + JSESSIONID);
        System.out.println("session = " + session);
        return "success";
    }

    //测试POJO,控制器形参为Bean对象,获取前端name属性名的value值
    @RequestMapping("/testPOJO.do")
    public String testPOJO(User user) {
        System.out.println("TestRequestParams.testPOJO");
        System.out.println("user = " + user);
        return "success";
    }
}
