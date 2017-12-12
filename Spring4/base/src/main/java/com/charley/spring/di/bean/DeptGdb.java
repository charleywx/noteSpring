package com.charley.spring.di.bean;

import com.charley.spring.di.annotation.MyAnnotation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@MyAnnotation
public class DeptGdb implements DeptEjdw {

    private String name = "DeptGdb - MyAnnotation";

    public String send() {
        return null;
    }

    public String getName() {
        return this.name;
    }

}
