package com.angryzyh.aop_annotation.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
/*多个增强切面对同一类的增强
* 设置通知等级
* int类型，数值越小越先执行
* 默认int的最大值，最后执行，数值可以为负数
* */
@Order(1)
public class UserProxy2 {
    /*抽取相同切入点*/
    @Pointcut("execution(* com.angryzyh.aop_annotation.bean.User.add(..))")
    public void pointcut() {
    }

    @Before("execution(* com.angryzyh.aop_annotation.bean.User.add(..))")
    public void before() {
        System.out.println("**Before前置增强");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("**After最终增强");
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("**AfterReturning返回值(后置)增强");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("**AfterThrowing异常增强");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("**Around环绕增强之前");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("**Around环绕增强之后");
        int i = (Integer) proceed + 1;
        return i;
    }
}
