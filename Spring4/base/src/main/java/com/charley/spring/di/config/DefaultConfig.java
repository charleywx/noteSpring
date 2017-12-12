package com.charley.spring.di.config;

import org.springframework.context.annotation.*;

/**
 * JAVAConfig配置类
 *
 * @Configuration 标记为配置类
 * @ComponentScan 默认扫描与配置类同包的组件
 * @ComponentScan("com.charley.spring") 扫描com.charley.spring包及子包下的所有组件
 * @ComponentScan(basePackages = {"com.charley.spring.di", "com.charley.spring.aop"}) 扫描di和aop两个包
 * @ComponentScan(basePackageClasses = {PersonOri.class, DeptOri.class}) 扫描这两个类文件
 */
@Configuration
@ComponentScan(basePackages = {"com.charley.spring"})
//@Import(OtherConfig.class)
//@ImportResource("/default.xml")
public class DefaultConfig {




}
