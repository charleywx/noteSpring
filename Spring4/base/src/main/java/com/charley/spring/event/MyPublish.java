package com.charley.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyPublish {

    @Autowired
    ApplicationContext applicationContext;

    public void publish(String msg) {
        // 用 applicationContext 发布事件，这个事件是new了一个MyEvent对象。
        applicationContext.publishEvent(new MyEvent(this, msg));
    }

}
