package com.angryzyh.spring5.config;

import com.angryzyh.spring5.config.pojo.IdCard;
import com.angryzyh.spring5.config.pojo.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;

//@Import({User.class,IdCard.class}) // 根据类文件注册Bean容器对象
@Configuration
//@Configuration(proxyBeanMethods = true) //默认true 代理Bean对象的方法
//@ConditionalOnBean(name = "user") //条件注册，当容器内有id为user的bean的时候，下面的bean才会被注册
//@ImportResource("classpath:xxx.xml") //导入老式的xml配置文件
public class At_Configuration {

    //添加Bean容器对象
    @Bean //容器的id 默认是方法名
    //@Scope("prototype")
    public User user1Bean() {
        return new User();
    }

    @Bean("user2") //name&value属性给容器指定id
    public User user2Bean() {
        return new User();
    }

    //每个身份证创建的时候
    @Bean("idCard")
    @Scope("prototype") //多例
    public IdCard sendIdCard() {
        IdCard idCard = new IdCard();
        idCard.setHolder(user1Bean());
        return idCard;
    }

}
