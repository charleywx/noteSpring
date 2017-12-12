package com.charley.spring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * XML注解方式，不需要添加任何注解
 */
public class AspectXml {

    private void before() {
        System.out.println("before");
    }

    /**
     * after 在 afterReturning和afterThrowing 前面执行
     */
    private void after() {
        System.out.println("after");
    }

    private void afterReturning() {
        System.out.println("afterReturning");
    }

    private void afterThrowing() {
        System.out.println("afterThrowing");
    }

    /**
     * 插入点：ProceedingJoinPoint
     * @param pjp
     */
    private void around(ProceedingJoinPoint pjp) {
        try {
            System.out.println("before01");
            System.out.println("before02");

            pjp.proceed();

            System.out.println("after01");
            System.out.println("after02");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("throwing");
        }
    }

    /**
     * 带参数的情况
     * 方法必须为public
     */
    public void after02(String newName) {
        System.out.println("after02 and args = " + newName);
    }

}
