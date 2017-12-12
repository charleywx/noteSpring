package com.charley.spring.aop.config;

import com.charley.spring.aop.aspect.AspectWithin;
import com.charley.spring.aop.within.WithStore1;
import com.charley.spring.aop.within.WithStore2;
import com.charley.spring.aop.within.WithStore3;
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
@ComponentScan(basePackageClasses = {WithStore1.class, WithStore2.class, WithStore3.class})
public class AopConfigWithin {

    @Bean
    public AspectWithin aspectWithin() {return new AspectWithin();}

}
