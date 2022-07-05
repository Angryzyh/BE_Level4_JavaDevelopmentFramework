package com.angryzyh.ioc_annotation;

import com.angryzyh.ioc_annotation.model.Employees;
import com.angryzyh.ioc_annotation.model.User;
import com.angryzyh.ioc_annotation.model.UserByValue;
import com.angryzyh.ioc_annotation.config.SpringConfig;
import com.angryzyh.ioc_annotation.service.UserService;
import com.angryzyh.ioc_annotation.service.impl.UserServiceImpl;
import com.angryzyh.ioc_annotation.service.impl.UserServiceImplByQualifier;
import com.angryzyh.ioc_annotation.service.impl.UserServiceImplByValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Create object by spring config
 * 完全注解开发，不用xml配置文件
 * 使用@Configuration 以及 @ComponentScan(basePackages = {"com.angryzyh.ioc_annotation"})
 * @author Angryzyh
 * @since 2022 -06-23 01:55:04
 */
public class CreateObjectBySpringConfig {
    ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);

    /**
     * Create object by annotation
     * 使用了@Component
     *
     * @author Angryzyh
     * @since 2022 -06-22 12:43:15
     */
    @Test
    public void createObjectByAnnotation() {
        User user = app.getBean("user", User.class);
        System.out.println("user = " + user);
    }

    /**
     * Create object by annotation auto wired 1
     * 使用了 @Service @Autowired
     *
     * @author Angryzyh
     * @since 2022 -06-23 01:19:38
     */
    @Test
    public void createObjectByAnnotationAutoWired1() {
        UserService userService = app.getBean("userServiceImpl", UserServiceImpl.class);
        User user = app.getBean("user", User.class);
        userService.userLogin(user);
    }

    /**
     * Create object by annotation auto wired 2
     * 根据service层指定的  @Qualifier(value = "userDaoImpl2") dao层实现类指定对象
     *
     * @author Angryzyh
     * @since 2022 -06-23 01:19:38
     */
    @Test
    public void createObjectByAnnotationAutoWired2() {
        UserService userService = app.getBean("userServiceImplByQualifier", UserServiceImplByQualifier.class);
        User user = app.getBean("user", User.class);
        userService.userLogin(user);
    }

    /**
     * Create object by annotation auto wired
     * 根据注解自动装配对象
     *
     * @author Angryzyh
     * @since 2022 -06-22 18:30:27
     */
    @Test
    public void createObjectByAnnotationAutoWired3() {
        Employees employees = app.getBean("employees", Employees.class);
        System.out.println("employees = " + employees);
    }

    /**
     * Create object by annotation by value
     * 给bean对象注入基本属性
     *
     * @author Angryzyh
     * @since 2022 -06-23 01:44:53
     */
    @Test
    public void createObjectByAnnotationByValue() {
        UserServiceImplByValue userService = app.getBean("userServiceImplByValue", UserServiceImplByValue.class);
        UserByValue userByValue = app.getBean("userByValue", UserByValue.class);
        userService.userLogin(userByValue);
    }
}
