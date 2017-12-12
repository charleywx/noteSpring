package com.charley.spring.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduleService1 {

    private final Logger log = LoggerFactory.getLogger(ScheduleService1.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static int i = 0;

    private Long startTimeMin = 0L;

    private Long endTimeMin = 0L;

    private String startTime = "";

    private String endTime = "";

    private static final int interval = 5 * 60 * 1000;

    /**
     * fixedRate 固定频率
     */
    @Scheduled(fixedRate = 5000)
    @Async
    public void currtime() {
        System.out.println("ScheduleService1.start");
        try {
            Thread.sleep(160000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ScheduleService1.end");
    }
    
    /**
     * fixedRate 固定频率
     */
    @Scheduled(fixedRate = 5000)
    @Async
    public void currtime1() {
        System.out.println("ScheduleService1.start");
        try {
            Thread.sleep(160000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ScheduleService1.end");
    }

    /*@Scheduled(fixedRate = (5 * 60 * 1000))
    private void initTime() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai")); *//* 修正时区 *//*
        final long now = System.currentTimeMillis();
        if(endTimeMin == 0) {
            endTimeMin = now - now % interval;
        } else {
            endTimeMin += interval;
        }
        startTimeMin = endTimeMin - interval;
        startTime = dateFormat.format(new Date(startTimeMin));
        endTime = dateFormat.format(new Date(endTimeMin));
        log.info(startTime);
        log.info(endTime);
        System.out.println("-----------------");
    }*/

    /**
     * cron 克隆
     */
    @Scheduled(cron = "0 1 0 ? * *")
    public void fixTime() {
        System.out.println("每天0点1分执行：" + dateFormat.format(new Date()));
    }

}
