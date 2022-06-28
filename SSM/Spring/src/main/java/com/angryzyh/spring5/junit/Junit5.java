package com.angryzyh.spring5.junit;

import com.angryzyh.spring5.junit.bean.Booker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/*@ExtendWith(SpringExtension.class)*/ //导入junit5框架
/*@ContextConfiguration("classpath:junit/ApplicationContext.xml")*/ //加载配置文件
@SpringJUnitConfig(locations = "classpath:junit/ApplicationContext.xml") //整合写法，合二为一
public class Junit5 {
    @Autowired
    private Booker booker;

    @Test
    public void demo() {
        System.out.println("booker = " + booker);
    }
}
