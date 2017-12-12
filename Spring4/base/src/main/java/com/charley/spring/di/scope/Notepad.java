package com.charley.spring.di.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Spring 创建bean的作用于有四种：
 * 1、单例（Singleton）
 * 2、原形（ProtoType）
 * 3、会话（Session）
 * 4、请求（Rquest）
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Notepad {
}
