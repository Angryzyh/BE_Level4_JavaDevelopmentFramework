package com.angryzyh.dynamic_proxy.dao.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UserDaoProxy implements InvocationHandler {

    private Object object;
    public UserDaoProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("增强代码，在原功能之前执行");
        System.out.println("执行原功能代码"+method.getName()+"传递的参数是:"+ Arrays.toString(args));
        /*
            调用原函数,传参第一个是代理类对象,第二个是方法所需参数
        * */
        Object invoke = method.invoke(object, args);
        System.out.println("原代码执行结果:invoke = " + invoke);
        System.out.println("增强代码,在原功能之后执行");
        return invoke;
    }
}
