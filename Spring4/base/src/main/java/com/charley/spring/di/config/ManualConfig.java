package com.charley.spring.di.config;

import com.charley.spring.di.bean.DeptEjdw;
import com.charley.spring.di.bean.DeptKgc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 显示注入、手工注入
 */
@Configuration
public class ManualConfig {

    /**
     * 显示注入：定义@Bean
     * Bean的默认Id为方法名，即deptKgc
     */
    @Bean
    public DeptEjdw deptKgc() {
        return new DeptKgc();
    }
}
