package com.angryzyh.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@SpringBootTest
public class TestData {
    @Autowired
    private UnitConfig unitConfig;

    @Test
    public void test01() {
        System.out.println("unitConfig = " + unitConfig);
        //比较大小
        int i = unitConfig.getGigabytes().compareTo(unitConfig.getTerabytes());
        System.out.println("i = " + i);
        //MB转换成B
        long bytes = unitConfig.getMegabytes().toBytes();
        System.out.println("bytes = " + bytes);
        //判断是否有数据 false 代表有
        boolean negative = unitConfig.getBytes().isNegative();
        System.out.println("negative = " + negative);
        //小转大  不可取
        long l = unitConfig.getBytes().toGigabytes();
        System.out.println("l = " + l);
    }

    //测试自定义
    @Test
    public void test02() {
        Duration timetemp = unitConfig.getTimetemp();
        System.out.println("timetemp = " + timetemp);

        //测试数据校验
        Integer sss = unitConfig.getSss();
        System.out.println("sss = " + sss);
    }
}
