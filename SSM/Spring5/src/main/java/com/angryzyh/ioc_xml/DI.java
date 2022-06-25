package com.angryzyh.ioc_xml;

import com.angryzyh.ioc_xml.bean.Collection;
import com.angryzyh.ioc_xml.bean.Employees;
import com.angryzyh.ioc_xml.bean.User;
import com.angryzyh.ioc_xml.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * DI依赖注入
 * @author Angryzyh
 * @since 2022 -06-19 17:14:44
 */
public class DI {
    ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("ioc_xml/ApplicationContext-DI.xml");

    /**
     * Set注入
     * @author Angryzyh
     * @since 2022 -06-19 17:14:44
     */
    @Test
    public void setDI() {
        User user1 = app.getBean("user1", User.class);
        System.out.println("user1 = " + user1);
    }

    /**
     * Arg constructor DI
     * 带参构造注入
     * @author Angryzyh
     * @since 2022 -06-19 17:14:44
     */
    @Test
    public void argConstructorDI() {
        User user2 = app.getBean("user2", User.class);
        User user3 = app.getBean("user3", User.class);
        System.out.println("user2 = " + user2);
        System.out.println("user3 = " + user3);
    }

    /**
     * P name space DI
     * p名称空间注入
     * 原理还是set注入
     * @author Angryzyh
     * @since 2022 -06-19 17:14:44
     */
    @Test
    public void pNameSpaceDI() {
        User user4 = app.getBean("user4", User.class);
        System.out.println("user4 = " + user4);
    }

    /**
     * Null DI
     * 空值注入
     * @author Angryzyh
     * @since 2022 -06-19 18:46:27
     */
    @Test
    public void nullDI() {
        User user5 = app.getBean("user5", User.class);
        System.out.println("user5 = " + user5);
    }

    /**
     * CDATA DI
     * 特殊值注入
     * @author Angryzyh
     * @since 2022 -06-19 18:46:27
     */
    @Test
    public void cdataDI() {
        User user6 = app.getBean("user6", User.class);
        System.out.println("user6 = " + user6);
    }

    /**
     * Out bean DI
     * 外部bean注入
     * @author Angryzyh
     * @since 2022 -06-19 19:45:47
     */
    @Test
    public void outBeanDI() {
        UserServiceImpl userServiceImpl = app.getBean("userServiceImpl", UserServiceImpl.class);
        User user1 = app.getBean("user1", User.class);
        userServiceImpl.userLogin(user1);
    }

    /**
     * In bean DI
     * 内部注入
     * @author Angryzyh
     * @since 2022 -06-19 20:07:02
     */
    @Test
    public void inBeanDI() {
        Employees emp1 = app.getBean("emp1", Employees.class);
        System.out.println("emp1 = " + emp1);
    }

    /**
     * Ref bean DI
     * 级联注入
     * @author Angryzyh
     * @since 2022 -06-19 20:13:27
     */
    @Test
    public void refBeanDI() {
        Employees emp2 = app.getBean("emp2", Employees.class);
        System.out.println("emp2 = " + emp2);
    }

    /**
     * Collection DI.
     * 集合类型属性注入 ,分别注入了 数组 list集合 map集合 set集合
     * @author Angryzyh
     * @since 2022 -06-20 00:13:06
     */
    @Test
    public void collectionDI() {
        Collection coll1 = app.getBean("coll1", Collection.class);
        System.out.println("coll1 = " + coll1);
    }

    /**
     * Util name space DI
     *  需要配置 名称空间
     * @author Angryzyh
     * @since 2022 -06-20 00:39:31
     */
    @Test
    public void utilNameSpaceDI() {
        Collection coll2 = app.getBean("coll2", Collection.class);
        System.out.println("coll2 = " + coll2);
    }


}
