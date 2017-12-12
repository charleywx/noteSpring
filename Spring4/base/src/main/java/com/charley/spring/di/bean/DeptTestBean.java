package com.charley.spring.di.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DeptTestBean {

    @Autowired
    @Qualifier("kgc")
    public DeptEjdw deptEjdw;

}
