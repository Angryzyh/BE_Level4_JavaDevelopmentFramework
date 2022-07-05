package com.angryzyh.ioc_xml;

import com.angryzyh.ioc_xml.model.Employees;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Auto wire
 * 自动装配
 * @author Angryzyh
 * @since 2022 -06-22 01:00:23
 */
public class AutoWire {

    /**
     * Test demo
     * @author Angryzyh
     * @since 2022 -06-22 01:00:23
     */
    @Test
    public void testDemo() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("ioc_xml/ApplicationContext-Autowrie.xml");
        Employees emp1 = app.getBean("emp1", Employees.class);
        System.out.println("emp1 = " + emp1);
    }
}
