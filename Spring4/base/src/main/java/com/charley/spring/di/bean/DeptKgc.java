package com.charley.spring.di.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("kgc")
public class DeptKgc implements DeptEjdw {

    private String name = "DeptKgc";

    public String send() {
        return null;
    }

    public String getName() {
        return this.name;
    }

}
