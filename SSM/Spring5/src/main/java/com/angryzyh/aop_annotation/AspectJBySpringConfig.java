package com.angryzyh.aop_annotation;

import com.angryzyh.aop_annotation.bean.User;
import com.angryzyh.aop_annotation.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectJBySpringConfig {
    /*spring完全注解
    * 通过加载配置文件类
    * */
    ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);

    @Test
    public void demo01() {
        User user = app.getBean("user", User.class);
        System.out.println("user = " + user);
        int add = user.add(1, 2);
        System.out.println("add = " + add);
    }
}
