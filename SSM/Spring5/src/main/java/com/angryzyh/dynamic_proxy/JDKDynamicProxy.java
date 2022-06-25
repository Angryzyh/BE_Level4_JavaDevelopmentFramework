package com.angryzyh.dynamic_proxy;

import com.angryzyh.dynamic_proxy.dao.UserDao;
import com.angryzyh.dynamic_proxy.dao.impl.UserDaoImpl;
import com.angryzyh.dynamic_proxy.dao.impl.UserDaoProxy;

import java.lang.reflect.Proxy;

public class JDKDynamicProxy {
        public static void main(String[] args) {
            Class[] interfaces = {UserDao.class};
            UserDaoImpl userDao = new UserDaoImpl();
        /*
          动态代理创建对象
          ClassLoader loader,使用反射获取对象的ClassLoader
          Class<?>[] interfaces,目标对象实现的接口，也是反射获取(需要增强的类的接口)
          InvocationHandler h , 我们自己写的，代理类要完成的功能(实现InvocationHandler接口,使用构造器传入要被代理的对象)
         */
            UserDao dao = (UserDao) Proxy.newProxyInstance(JDKDynamicProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int result = dao.add(1, 2);
        System.out.println("result = " + result);
    }
}
