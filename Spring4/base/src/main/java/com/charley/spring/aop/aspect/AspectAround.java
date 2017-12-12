package com.charley.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 循环通知方法
 */
@Aspect
public class AspectAround {

    @Pointcut("execution(* com.charley.spring.aop.within.WithStore2.start())")
    public void point() {
    }

    /**
     * 环绕通知
     *
     * @param jp
     * @Around 方式注入
     */
    @Around("point())")
    public void around1(ProceedingJoinPoint jp) {
        try {
            System.out.println("around1 before1");
            System.out.println("around1 before2");

            // 不调用proceed()方法，则阻塞WithStore2.start()方法的访问。
            jp.proceed();

            System.out.println("around1 afterReturning");
        } catch (Throwable e) {
            System.out.println("around1 afterThrowing");
        }
    }

}
