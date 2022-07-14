package com.angryzyh.spring5.config.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component  标志组件 注册成bean
//@ConfigurationProperties(prefix = "aaa.bbb.ccc") //从主配置文件中找到aaa.bbb.ccc下面的配置信息导入到 属性中
// 1. ConfigurationProperties + @Component 组合 导入配置信息
// 2. ConfigurationProperties + @EnableConfigurationProperties(该注解要在配置类内，开启属性绑定生效)
public class User {
    private Integer id;
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
