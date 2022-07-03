package com.angryzyh.thymeleaf.controller;

import com.angryzyh.thymeleaf.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/*
 * HttpMessageConverter，报文信息转换器，
 * 将请求报文转换为Java对象，或将Java对象转换为响应报文
 * HttpMessageConverter提供了两个注解和两个类型：
 * @RequestBody 在控制器形参上注解
 * @ResponseBody 在方法上注解 返回值发送数据,传参
 * RequestEntity
 * ResponseEntity 作为控制器的返回值类型 用于文件下载
 *
 * @RestController 在类上注解,所有控制器的方法返回值用于传参
 * 相当于类上加了@Controller,所有方法上加了@ResponseBody
 * */
@Controller
public class TestHttpMessageConverter {

    //测试获取请求的请求提体信息，使用@RequestBody注解绑定一个控制器形参,post请求
    @RequestMapping("/testRequestBody.do")
    public String testRequestBody(@RequestBody String requestBody) {
        //输出结果是请求体信息，输出样例：requestBody:username=111&password=111
        System.out.println("requestBody:" + requestBody);
        return "success";
    }

    //测试获取请求的报文信息，在控制器方法形参中使用RequestEntity类型参数接收
    @RequestMapping("/testRequestEntity.do")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        //当前requestEnity表示整个请求报文的信息
        /* 请求头：
         * [host:"localhost:8080",
         * connection:"keep-alive",
         * content-length:"25",
         * cache-control:"max-age=0",
         * sec-ch-ua:"" Not;A Brand";v="99", "Microsoft Edge";v="103", "Chromium";v="103"",
         * sec-ch-ua-mobile:"?0",
         * sec-ch-ua-platform:""Windows"",
         * upgrade-insecure-requests:"1",
         * origin:"http://localhost:8080",
         * user-agent:"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5060.66 Safari/537.36 Edg/103.0.1264.44",
         * accept:"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*//*;q=0.8,application/signed-exchange;v=b3;q=0.9",
         * sec-fetch-site:"same-origin",
         * sec-fetch-mode:"navigate",
         * sec-fetch-user:"?1",
         * sec-fetch-dest:"document",
         * referer:"http://localhost:8080/SpringMVC/",    //重点，该位置可以获取上下文路径
         * accept-encoding:"gzip, deflate, br",
         * accept-language:"zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6",
         * cookie:"Idea-e2f29785=aabb8302-e600-4fd1-85b9-5d629b80509a",
         * Content-Type:"application/x-www-form-urlencoded;charset=UTF-8"]
         **/
        System.out.println("请求头：" + requestEntity.getHeaders());
        //请求体：username=222&password=222
        System.out.println("请求体：" + requestEntity.getBody());
        return "success";
    }

    //测试使用servlet-api 获取响应对象，向前端传送数据
    @RequestMapping(value = "/testResponse.do", produces = "text/html;charset=UTF-8")
    public void testResponse(HttpServletResponse response) throws IOException {
        User user = new User();
        user.setUserId(11);
        user.setUserName("小虎");
        //该部分内容会作为响应体传送到浏览器
        response.getWriter().print(user + "hello,response,<i>i</i> am print" + "<br>");
        response.getWriter().write(user + "hello,response,<b>i</b> am write");
    }

    //测试@ResponseBody注解控制器,控制器返回值输出到浏览器
    @RequestMapping(value = "/testResponseBody.do")
    @ResponseBody
    public String testResponseBody() {
        return "成功";
    }

    //测试@ResponseBody注解控制器,将Java对象直接作为控制器方法的返回值返回，就会自动转换为Json格式的字符串
    @RequestMapping("/testResponseBodyReturnUser.do")
    @ResponseBody
    public User testResponseBodyReturnUser() {
        return new User("jack", "admin", "男", 23, "123@qq.com");
    }

    //同上, 返回map集合
    @RequestMapping("/testResponseBodyByReturnMapUser.do")
    @ResponseBody
    public Map<String, User> testResponseBodyReturnMapUser() {
        Map<String, User> map = new HashMap<>();
        User user1 = new User("jack1", "admin1", "男", 23, "123@qq.com");
        User user2 = new User("jack2", "admin2", "男", 24, "123@qq.com");
        map.put("1", user1);
        map.put("2", user2);
        return map;
    }

    //同上返回list集合
    @RequestMapping("/testResponseBodyByReturnListUser.do")
    @ResponseBody
    public List<User> testResponseBodyReturnListUser() {
        List<User> list = new LinkedList<>();
        User user1 = new User("jack1", "admin1", "男", 23, "123@qq.com");
        User user2 = new User("jack2", "admin2", "男", 24, "123@qq.com");
        User user3 = new User("jack3", "admin2", "男", 24, "123@qq.com");
        User user4 = new User("jack4", "admin2", "男", 24, "123@qq.com");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        Collections.addAll(list, user3, user4);
        for (User user : list) {
            System.out.println("user = " + user);
        }
        return list;
    }

    //@ResponseBody注解. 实现ajax异步刷新,当前页面传值
    @RequestMapping("/testResponseBodyByAxios.do")
    @ResponseBody
    public String testAxios(String username, String password) {
        System.out.println(username + "," + password);
        return "hello,axios";
    }

}
