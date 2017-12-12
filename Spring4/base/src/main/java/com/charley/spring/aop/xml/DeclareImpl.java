package com.charley.spring.aop.xml;

import org.springframework.beans.factory.annotation.Autowired;

public class DeclareImpl implements DeclareBasic {

    public void start() {
        System.out.println("DeclareImpl is start");
    }

}
