package com.charley.spring.aop.aspect;

import com.charley.spring.aop.service.CheckUserService;
import com.charley.spring.aop.service.CheckUserServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class AspectDeclare {

    /**
     * 1、value 被引用的对象
     * 2、defaultImpl 实现类，方法注入的类
     * 3、方法返回的接口类
     */
    @DeclareParents(value = "com.charley.spring.aop.service.UserLogin+", defaultImpl = CheckUserServiceImpl.class)
    public static CheckUserService checkUserService1;

    @DeclareParents(value = "com.charley.spring.aop.service.UserIf+", defaultImpl = CheckUserServiceImpl.class)
    public static CheckUserService checkUserService2;

}
