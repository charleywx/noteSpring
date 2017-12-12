package com.charley.spring.di.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAspectJAutoProxy // 开启对AsceptJ自动代理支持
@EnableAsync // 开启异步方法支持
@EnableScheduling // 开启计划任务支持

@EnableWebMvc // 开启WebMvc的配置支持

@EnableConfigurationProperties // 开启对@ConfigurationProperties注解配置Bean的支持
@EnableTransactionManagement // 开启主解式事务的支持
@EnableCaching // 开启主解式的缓存支持
public class EnableConfig {
}
