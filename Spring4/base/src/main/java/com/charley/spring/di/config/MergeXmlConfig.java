package com.charley.spring.di.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 合并配置类
 */
@Configuration
@Import(DefaultConfig.class)
@ImportResource("/appTestSpring.xml")
public class MergeXmlConfig {
}
