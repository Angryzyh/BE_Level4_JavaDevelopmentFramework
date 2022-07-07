package com.angryzyh.aop_annotation.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserProxy {
    /*抽取相同切入点*/
    @Pointcut("execution(* com.angryzyh.aop_annotation.service.User.add(..))")
    public void pointcut() {
    }

    /*前置通知*/
    @Before("execution(* com.angryzyh.aop_annotation.service.User.add(..))")
    public void before() {
        System.out.println("Before前置增强");
    }

    /*异常通知*/
    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("AfterThrowing异常增强");
    }

    /*后置（返回值）通知*/
    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("AfterReturning返回值(后置)增强");
    }

    /*最终通知*/
    @After("pointcut()")
    public void after() {
        System.out.println("After最终增强");
    }

    /*环绕通知*/
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around环绕增强之前");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("Around环绕增强之后");
        int i = (Integer) proceed + 1;
        return i;
    }
}
