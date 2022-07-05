package com.angryzyh.tx_annotation;

import com.angryzyh.tx_annotation.model.Custom;
import com.angryzyh.tx_annotation.service.impl.CustomServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TXAnnotationTest {
    ApplicationContext app = new ClassPathXmlApplicationContext("tx_annotation/ApplicationContext.xml");
    Custom custom1 = app.getBean("custom", Custom.class);
    Custom custom2 = app.getBean("custom", Custom.class);
    CustomServiceImpl customService = app.getBean("customServiceImpl",CustomServiceImpl.class);

    @Test
    public void transferMoneyTest() {
        custom1.setcName("jack");
        custom2.setcName("lucy");
        customService.transferMoney(custom1, custom2, 100);
    }
}
