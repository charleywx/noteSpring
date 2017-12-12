package com.charley.spring.schedule;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class ScheduleService {

    private final Logger log = LoggerFactory.getLogger(ScheduleService.class);

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
    @Scheduled(fixedRate = 3000)
    @Async
    public void currtime() {
        try {
            if(i == 0) {
//                Thread.sleep(1*1000);
            } else if (i == 1){
                Thread.sleep(16*1000);
            } else if (i == 2){
//                Thread.sleep(1*1000);
            }
            i++;
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("每3秒钟执行一次 " + dateFormat.format(new Date()));
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
