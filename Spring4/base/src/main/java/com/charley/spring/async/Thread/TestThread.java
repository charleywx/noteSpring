package com.charley.spring.async.Thread;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestThread {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ThreadConfig.class);
    }
}
