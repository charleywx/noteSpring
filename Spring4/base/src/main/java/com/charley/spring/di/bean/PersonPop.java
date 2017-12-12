package com.charley.spring.di.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 原始的BEAN，使用XML注入
 */
@Component
public class PersonPop {

    @Value("${popYear}")
    public String pName;

    @Value("${popYear}")
    public String pAge;

}
