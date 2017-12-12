package com.charley.spring.event;

import javafx.application.Application;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 监听MyEvent对象
 */
@Component
public class MyLintener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        String msg = event.getMsg();
        System.out.println("MyLintener 输出：msg = " + msg);
    }

}
