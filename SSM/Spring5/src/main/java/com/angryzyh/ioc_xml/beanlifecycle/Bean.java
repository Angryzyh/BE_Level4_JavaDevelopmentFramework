package com.angryzyh.ioc_xml.beanlifecycle;

public class Bean {
    private String property1;
    private String property2;
    private String property3;

    public Bean() {
        System.out.println("第一步，无参构造创建bean实例对象");
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        System.out.println("第二部，set注入属性：property1 = " + property1);
        this.property1 = property1;
    }

    /*创建初始化方法*/
    public void initMethod() {
        System.out.println("第三步，执行初始化方法");
    }

    /*创建销毁方法*/
    public void destroyMethod() {
        System.out.println("第五步，执行销毁方法");
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public String getProperty3() {
        return property3;
    }

    public void setProperty3(String property3) {
        this.property3 = property3;
    }
}
