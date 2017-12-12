package com.charley.spring.di.config;

import com.charley.spring.di.bean.Dept;
import com.charley.spring.di.condition.CommonCondition;
import com.charley.spring.di.original.DeptOri;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:system.prop")
public class ConditionConfig {

    @Bean
    public DeptOri deptOri() {
        return new DeptOri();
    }

    /**
     * 自定义条件加载Bean
     * CommonCondition.matches方法返回true时加载
     * @return
     */
    @Bean
    @Conditional(CommonCondition.class)
    public Dept dept() {
        return new Dept();
    }

}
