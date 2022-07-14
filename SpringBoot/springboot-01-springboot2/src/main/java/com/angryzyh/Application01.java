package com.angryzyh;

import com.angryzyh.spring5.config.pojo.IdCard;
import com.angryzyh.spring5.config.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = {"com.angryzyh"}) //默认扫描该包下组件，整合下面三个注解
/*@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.angryzyh"})*/
public class Application01 {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(Application01.class, args);

        System.out.println("1.****************************************************************");
        //探究Bean容器的创建，默认单例模式
        User user1 = (User) app.getBean("user1Bean");
        User user1c = (User) app.getBean("user1Bean",User.class);
        System.out.println("调用同一个Bean容器创建对象===>" +  user1.equals(user1c));
        User user2 = app.getBean("user2", User.class);
        System.out.println("调用不同的Bean容器创建同一个类型的对象===>" + user1.equals(user2));

        System.out.println("2.****************************************************************");
        //探究一个Bean注入另一个Bean
        IdCard idCard = app.getBean("idCard", IdCard.class);
        IdCard idCard2 = app.getBean("idCard", IdCard.class);
        User holder1 = idCard.getHolder();
        User holder2 = idCard2.getHolder();
        boolean equals = holder1.equals(holder2);
        //探究Bean是否多例  @Scope("prototype")多例
        System.out.println("Bean本身 = " + idCard.equals(idCard2));
        //Bean的方法 默认被代理所以方法是同一个
        System.out.println("Bean的方法 = " + equals);

    }


}
