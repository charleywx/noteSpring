package com.charley.spring.aop.config;

import com.charley.spring.aop.aspect.AspectAround;
import com.charley.spring.aop.aspect.AspectPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @EnableAspectJAutoProxy 启用自动代理功能
 * 将AspectBean注册为Bean
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.charley.spring.aop.within")
public class AopConfig {

    @Bean
    public AspectPoint aspectConfig() {
        return new AspectPoint();
    }

    @Bean
    public AspectAround aspectAround() {return new AspectAround();}

}
