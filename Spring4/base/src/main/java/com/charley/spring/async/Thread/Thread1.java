package com.charley.spring.async.Thread;

import com.charley.spring.util.DateUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Thread1 {
    
    @PostConstruct
    public void run() {
        new Thread(){
            @Override
            public void run() {
                System.out.println(DateUtil.getNowTimeStr());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    
}
