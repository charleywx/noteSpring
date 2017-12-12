package com.charley.spring.di.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Primary 注解表明唯一
 */
@Component
//@Primary
@Qualifier("ghj")
public class DeptGhj implements DeptEjdw {

    private String name = "DeptGhj";

    public String send() {
        return null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
