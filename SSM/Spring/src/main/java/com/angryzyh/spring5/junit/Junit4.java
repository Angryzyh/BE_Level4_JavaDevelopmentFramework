package com.angryzyh.spring5.junit;

import com.angryzyh.spring5.junit.bean.Booker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //junit4单元测试框架
@ContextConfiguration("classpath:junit/ApplicationContext.xml") //加载配置文件
public class Junit4 {

    @Autowired
    private Booker booker;

    @Test
    public void demo() {
        System.out.println("booker = " + booker);
    }
}
