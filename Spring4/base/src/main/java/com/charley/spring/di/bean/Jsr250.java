package com.charley.spring.di.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 使用Jsr250隐式的注解
 * @PostConstruct 在构造函数执行完成之后执行
 * @PreDestroy 在Bean销毁之前执行
 *
 * @Component @Service @RepositoryConfig @Controller 等效，但是在SpringMvc中@Controller有特殊用途
 */
@Service
public class Jsr250 {

    @Value("${path}")
    private String path;

    @Value("${sql}")
    private String sql;

    @PostConstruct
    public void init() {
        System.out.println("Jsr250 init");
        System.out.println(path);
        System.out.println(sql);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Jsr250 destroy");
    }

}
