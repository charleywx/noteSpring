package com.charley.spring.di.config;

import com.charley.spring.di.bean.Dept;
import com.charley.spring.di.bean.Person;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {Dept.class, Person.class})
public class DeptConfig {
    
}
