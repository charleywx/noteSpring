package com.charley.spring.aop.aspect;

import org.aspectj.lang.annotation.*;

/**
 * 用到Aspect注解，来源于AspectJ包，表示该类为一个POJO，也是一个切面
 * 通过显示的注入Bean
 *
 * 共5种通知方法
 */
@Aspect
public class AspectPoint {

    @Pointcut("execution(* com.charley.spring.aop.within.WithStore2.start())")
    public void point1() {}

    @Before("point1())")
    public void before1() {
        System.out.println("before1");
    }

    /**
     * 前置通知
     */
    @Before("point1())")
    public void before2() {
        System.out.println("before2");
    }

    /**
     * 后置通知
     */
    @After("point1())")
    public void after() {
        System.out.println("after");
    }

    /**
     * 返回通知
     */
    @AfterReturning("point1())")
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("point1())")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

}
