package com.charley.spring.aop.config;

import com.charley.spring.aop.aspect.AspectDeclare;
import com.charley.spring.aop.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopDeclare {

    /**
     * 定义bean
     */
    @Bean
    public UserLogin userLogin() {
        return new UserLogin();
    }

    /**
     * 定义UserLogin的继承类
     */
    @Bean
    public UserLoginImpl userLogin1() {
        return new UserLoginImpl();
    }

    /**
     * 定义接口，返回实现类
     */
    @Bean
    public UserIf userIf() {
        return new UserIfImpl();
    }

    /**
     * 定义切面
     */
    @Bean
    public AspectDeclare aspectDeclare() {
        return new AspectDeclare();
    }

}
