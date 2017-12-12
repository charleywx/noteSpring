package com.charley.spring.di.bean;

import org.springframework.stereotype.Service;

/**
 * 使用@Bean显示的注解
 */
public class Jsr250Bean {

    public void init() {
        System.out.println("init");
    }

    public void destroy() {
        System.out.println("destroy");
    }

}
