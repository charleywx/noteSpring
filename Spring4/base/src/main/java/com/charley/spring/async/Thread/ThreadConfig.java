package com.charley.spring.async.Thread;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan
@EnableAsync
// Constructor > @PostConstruct > InitializingBean > init-method
public class ThreadConfig {
}
