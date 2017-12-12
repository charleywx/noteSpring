package com.charley.spring.aop.within;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
public class WithStore1 {

    public void start() throws FileNotFoundException {
        System.out.println("WithStore1");
//        throw new FileNotFoundException();
    }

    public String getInfo() {
        return "withStore1";
    }

}
