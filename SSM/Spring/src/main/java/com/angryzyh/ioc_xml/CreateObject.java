package com.angryzyh.ioc_xml;

import com.angryzyh.ioc_xml.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The type Create object.
 *  It has three ways to create object
 *  演示无参构造创建对象,静态工厂创建对象,动态实例工厂创建对象
 * @author Angryzyh
 * @since 2022 -06-19 14:44:25
 */
public class CreateObject{
    /**
     * Create object by no argument constructor.
     * bean容器默认无参构造创建对象
     * @author Angryzyh
     * @since 2022 -06-19 14:44:25
     */
    @Test
    public void createObjectByNoArgConstructor() {
        ApplicationContext app = new ClassPathXmlApplicationContext("ioc_xml/ApplicationContext-CreateObject.xml");
        /*验证bean容器对象默认单例,结果两个对象的hashCode应该是一样的,默认scope:singleton*/
        User user1 = app.getBean("user1", User.class);
        System.out.println("user1 = " + user1);
        System.out.println("user1 = " + user1.hashCode());
        User user11 = app.getBean("user1", User.class);
        System.out.println("user11 = " + user11);
        System.out.println("user11 = " + user11.hashCode());
        System.out.println("===============================");
        /*验证在bean容器内添加scope属性为prototype后为创建多例对象,两者hashCode不一致*/
        User user2 = app.getBean("user2", User.class);
        System.out.println("user2 = " + user2);
        System.out.println("user2 = " + user2.hashCode());
        User user22 = app.getBean("user2", User.class);
        System.out.println("user22 = " + user22);
        System.out.println("user22 = " + user22.hashCode());
    }
}
