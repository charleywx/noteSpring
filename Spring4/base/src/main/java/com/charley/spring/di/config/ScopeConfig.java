package com.charley.spring.di.config;

import com.charley.spring.di.scope.Notepad;
import com.charley.spring.di.scope.ShoppingCart;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

/**
 * Spring 创建bean的作用于有四种：
 * 1、单例（Singleton）
 * 2、原形（ProtoType）
 * 3、会话（Session）
 * 4、请求（Rquest）
 */
@Configuration
public class ScopeConfig {

    /**
     * 单例
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Notepad notepad() {
        return new Notepad();
    }

//    /**
//     * 原型
//     */
//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    public Notepad notepad() {
//        return new Notepad();
//    }

    @Bean
    @Scope( value = WebApplicationContext.SCOPE_SESSION,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ShoppingCart cart() {
        return new ShoppingCart();
    }

}
