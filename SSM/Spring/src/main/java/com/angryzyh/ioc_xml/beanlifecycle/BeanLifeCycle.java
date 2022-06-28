package com.angryzyh.ioc_xml.beanlifecycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean life cycle
 * bean的生命周期
 * @author Angryzyh
 * @since 2022 -06-22 01:01:03
 */
public class BeanLifeCycle {
    /**
     * Test demo
     * @author Angryzyh
     * @since 2022 -06-22 01:01:03
     */
    @Test
    public void testDemo(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("ioc_xml/ApplicationContext-BeanLifeCycle.xml");
        Bean bean1 = app.getBean("bean1", Bean.class);
        System.out.println("第四步，获取bean容器实例的对象：bean1 = " + bean1);
        app.close();
    }
}
