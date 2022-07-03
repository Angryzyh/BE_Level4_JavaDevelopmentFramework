package com.angryzyh.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestView {
    //测试springMVC配置Thymeleaf视图解析器后创建ThymeleafView视图
    @RequestMapping("/testThymeleafView.do")
    public String testThymeleafView() {
        return "success";
    }

    //测试forward:转发，创建InternalResourceView视图
    @RequestMapping("/testForward.do")
    public String testForward(Model model) {
        System.out.println("TestView.testForward");
        model.addAttribute("testRequestScope", "TestView.testForward");
        return "forward:/testThymeleafView.do";
    }

    //测试redirect:重定向，创建RedirectView视图
    @RequestMapping("/testRedirect.do")
    public String testRedirect(Model model, HttpSession session, HttpServletRequest request) {
        System.out.println("TestView.testRedirect");
        request.setAttribute("testRequestScope", "TestView.testRedirect");
        model.addAttribute("testModelScope", "TestView.testRedirect");
        session.setAttribute("testSessionScope", "TestView.testRedirect");
        return "redirect:/testThymeleafView.do";
    }

    //测试ModelAndView 对象创建视图
    @RequestMapping("/testThymeleafViewByModelAndView.do")
    public ModelAndView testThymeleafViewByModelAndView() {
        ModelAndView mav = new ModelAndView();
        System.out.println("TestView.testThymeleafViewByModelAndView");
        mav.addObject("testModelScope","TestView.testThymeleafViewByModelAndView");
        mav.setViewName("redirect:/testThymeleafView.do");
        return mav;
    }
}
