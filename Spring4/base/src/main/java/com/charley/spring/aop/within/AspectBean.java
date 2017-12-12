package com.charley.spring.aop.within;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用到Aspect注解，来源于AspectJ包，表示该类为一个POJO，也是一个切面
 * 隐式注入Bean
 */
@Component
@Aspect
public class AspectBean {

    @Before("execution(* com.charley.spring.aop.within.WithStore1.start())")
    public void before1() {
        System.out.println("AspectBean.before1");
    }

    /**
     * 方法之前执行
     */
    @Before("execution(* com.charley.spring.aop.within.WithStore1.start())")
    public void before2() {
        System.out.println("AspectBean.before2");
    }

    /**
     * 只要返回就执行，不管有没有异常
     */
    @After("execution(* com.charley.spring.aop.within.WithStore1.start())")
    public void after() {
        System.out.println("AspectBean.after");
    }

    /**
     * 无异常时执行
     */
    @AfterReturning("execution(* com.charley.spring.aop.within.WithStore1.start())")
    public void afterReturning() {
        System.out.println("AspectBean.afterReturning");
    }

    /**
     * 异常时执行
     */
    @AfterThrowing("execution(* com.charley.spring.aop.within.WithStore1.start())")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

}
