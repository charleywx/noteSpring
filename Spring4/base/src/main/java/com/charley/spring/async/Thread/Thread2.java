package com.charley.spring.async.Thread;

import com.charley.spring.util.DateUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Thread2 extends Thread {
    @PostConstruct
    @Async
    @Override
    public void run() {
        System.out.println(DateUtil.getNowTimeStr());
    }
}
