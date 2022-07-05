package com.angryzyh.aop_annotation;

import com.angryzyh.aop_annotation.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJ {
    ApplicationContext app = new ClassPathXmlApplicationContext("aop_annotation/ApplicationContext-AspectJ.xml");

    @Test
    public void demo01() {
        User user = app.getBean("user", User.class);
        System.out.println("user = " + user);
        int add = user.add(1, 2);
        System.out.println("add = " + add);
    }
}
