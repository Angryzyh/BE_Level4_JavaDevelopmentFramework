package com.angryzyh.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//                                   此处优先级 大于 @Value
@SpringBootTest(properties = {"testconfig.testvalue=hello@Value1"})
//@Import(xxx.class) 为当前的测试类导入专门的被 @Configuration注解的配置类文件
public class TestConfig {

    //导入配置文件参数
    @Value("${testconfig.testvalue}")
    private String testV;

    @Test
    public void testConfig() {
        System.out.println("testV = " + testV);
    }
}
