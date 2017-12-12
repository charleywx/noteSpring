package com.charley.spring.di.config;

import com.charley.spring.test.TestPropertyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

/**
 * 配置@PropertySource之后，可以直接使用@Value标签
 * @Value 可用于变量、方法的参数
 */
@Configuration
@PropertySource("classpath:system.prop")
@ComponentScan(basePackageClasses = TestPropertyBean.class)
public class PropertyConfig {

    @Autowired
    public Environment environment;

//    @Bean
//    public Dept dept() {
//        System.out.println(environment.getProperty("year"));
//        System.out.println(environment.getProperty("month"));
//
//        // 若没有month1属性，则返回“newMonth”
//        System.out.println(environment.containsProperty("month1"));
//        System.out.println(environment.getProperty("month1"));
//        System.out.println(environment.getProperty("month1", "newMonth"));
//
//        // 若必须要求有值时
//        try {
//            System.out.println(environment.getRequiredProperty("month1"));
//        } catch (IllegalStateException e) {
//            System.out.println("错误：没有month1属性");
//        }
//
//        return new Dept();
//    }
//
//    /**
//     * 配置延迟加载
//     * @return
//     */
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }

}
