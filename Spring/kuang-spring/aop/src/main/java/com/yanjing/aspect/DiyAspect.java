package com.yanjing.aspect;

/**
 * @author yanjing
 * @date 2021/8/21
 */
public class DiyAspect {

    public void before(){
        System.out.println("---------第二种AOP实现方法执行前---------");
    }
    public void after(){
        System.out.println("---------第二种AOP实现方法执行后---------");
    }
}
