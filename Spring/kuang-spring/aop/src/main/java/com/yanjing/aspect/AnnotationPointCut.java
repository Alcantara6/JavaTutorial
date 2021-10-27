package com.yanjing.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author yanjing
 * @date 2021/8/21
 */
@Aspect
public class AnnotationPointCut {

    @Before("execution(* com.yanjing.service.UserServiceImpl3.*(..))")
    public void before(){
        System.out.println("---------注解方式方法执行前---------");
    }

    @After("execution(* com.yanjing.service.UserServiceImpl3.*(..))")
    public void after(){
        System.out.println("---------注解方式方法执行后---------");
    }

    @Around("execution(* com.yanjing.service.UserServiceImpl3.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("-------环绕前------");
        // 执行方法
        Signature signature = jp.getSignature();
        jp.proceed();
        System.out.println("--------环绕后--------");
    }
}
