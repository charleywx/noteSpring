package com.charley.spring.aop.within;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 切面实现参数调用
 */
@Component
@Aspect
public class AspectParam {

    /**
     * 定义切点
     * 切点继承了来至 WithStore3.start 的参数值
     */
    @Pointcut("execution(* com.charley.spring.aop.within.WithStore3.start(int)) && args(num1)")
    public void point(int num1) {
        // 该方法不会被执行
        System.out.println("AspectParam.point.num1 = " + num1);
    }

    /**
     * 切点之前执行方法
     */
    @Before("point(num2)")
    public void before(int num2) {
        // 继承了来至 切点的参数值
        System.out.println("切点之前执行方法 AspectParam.before.num2 = " + num2);
    }

}
