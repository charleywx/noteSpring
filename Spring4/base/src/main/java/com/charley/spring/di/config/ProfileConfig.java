package com.charley.spring.di.config;

import com.charley.spring.di.bean.Dept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Profile 可用于类级别和方法级别
 * 激活Profile的6种方式：
 * 1、作为DispatcherServlet的初始参数；
 * 2、作为Web应用的上下文参数；
 * 3、作为JNDI的条目；
 * 4、作为环境变量；
 * 5、作为JVM的系统属性；
 * 6、在集成测试类上，使用@ActiveProfiles注解设置。
 *
 * @Profile 是根据类名来注解的，是单例。如果有多个则有歧义性。如dev环境下的 dept1 和 dept3
 *
 * 默认查找spring.profiles.default, 若有spring.profiles.active则用active的值。若都没有则只加载没有定义@Profile的bean
 */
@Configuration
//@Profile("dev")
public class ProfileConfig {

    @Bean(name = "dept1")
    @Profile("dev")
    public Dept dept1() {
        Dept dept = new Dept();
        dept.namePub = "dept1111";
        return dept;
    }

    @Bean(name = "dept2")
    @Profile("test")
    public Dept dept2() {
        Dept dept = new Dept();
        dept.namePub = "dept2222";
        return dept;
    }

    @Bean(name = "dept3")
    public Dept dept3() {
        Dept dept = new Dept();
        dept.namePub = "dept3333";
        return dept;
    }

}
