package com.angryzyh.tx_annotation;

import com.angryzyh.tx_annotation.model.Custom;
import com.angryzyh.tx_annotation.config.SpringConfig;
import com.angryzyh.tx_annotation.service.impl.CustomServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TXAnnotationBySpringConfigTest {
    ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
    Custom custom1 = app.getBean("custom", Custom.class);
    Custom custom2 = app.getBean("custom", Custom.class);
    CustomServiceImpl customService = app.getBean("customServiceImpl",CustomServiceImpl.class);

    @Test
    public void transferMoneyTest() {
        custom1.setcName("jack");
        custom2.setcName("lucy");
        this.customService.transferMoney(custom1, custom2, 100);
    }
}
