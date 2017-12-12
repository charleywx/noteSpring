package com.charley.spring.schedule;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * schedule 计划
 */
@Configuration
@ComponentScan("com.charley.spring.schedule")
@EnableScheduling // 允许定时任务
@EnableAsync
public class ScheduleConfig {
}
