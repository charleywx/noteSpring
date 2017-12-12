package com.charley.spring.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 测试winthin
 */
@Component
@Aspect
public class AspectWithin {

    /**
     * 定义一个切点：
     * 只要包com.charley.spring.aop.within.* 包下的任意类的方法被调用时
     */
    @Pointcut("within(com.charley.spring.aop.within.*)")
    private void point() {
    }

    @Before("point()")
    public void before1() {
        System.out.println("AspectWithin.before1");
    }

    @Before("point()")
    public void before2() {
        System.out.println("AspectWithin.before2");
    }

    @After("point()")
    public void after() {
        System.out.println("AspectWithin.after");
    }

}
