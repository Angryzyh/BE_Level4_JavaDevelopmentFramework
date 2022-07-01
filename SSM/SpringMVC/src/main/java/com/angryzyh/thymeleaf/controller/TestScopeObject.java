package com.angryzyh.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class TestScopeObject {
    //使用servletAPI向request域对象共享数据
    @RequestMapping("/testRequestByServletAPI.do")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope", "hello,servletAPI");
        return "success";
    }

    //使用ModelAndView向request域对象共享数据
    @RequestMapping("/testModelAndView.do")
    public ModelAndView testModelAndView(){
        ModelAndView mav = new ModelAndView();
        //处理模型数据，即向请求域request共享数据
        mav.addObject("testRequestScope", "hello,ModelAndView");
        //设置视图名称
        mav.setViewName("success");
        System.out.println(mav.getClass().getName());
        return mav;
    }

    //使用Model向request域对象共享数据
    @RequestMapping("/testModel.do")
    public String testModel(Model model){
        model.addAttribute("testRequestScope", "hello,Model");
        System.out.println(model.getClass().getName());
        return "success";
    }

    //使用Map集合向request域对象共享数据
    @RequestMapping("/testMap.do")
    public String testMap(Map<String, Object> map){
        map.put("testRequestScope", "hello,map");
        System.out.println(map.getClass().getName());
        return "success";
    }

    //使用ModelMap向request域对象共享数据
    @RequestMapping("/testModelMap.do")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope", "hello,ModelMap");
        System.out.println(modelMap.getClass().getName());
        return "success";
    }

    //使用servletAPI向session域对象共享数据
    @RequestMapping("/testSession.do")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    //使用servletAPI向application域对象共享数据
    @RequestMapping("/testApplication.do")
    public String testApplication(HttpSession session){
        ServletContext app = session.getServletContext();
        app.setAttribute("testApplication", "hello,application");
        return "success";
    }
}
