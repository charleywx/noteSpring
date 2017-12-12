package com.charley.spring.di.config;

import com.charley.spring.di.bean.Jsr250Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.charley.spring.di.bean"})
@PropertySource("classpath:system.prop")

public class QualifierConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Jsr250Bean jsr250Bean() {
        return new Jsr250Bean();
    }

}
