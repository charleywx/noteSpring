package com.charley.spring.schedule;

import com.charley.spring.async.AsyncConfig;
import com.charley.spring.async.AsyncService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduleConfig.class);
    }

}
