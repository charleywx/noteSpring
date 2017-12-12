package com.charley.spring.di.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 实现Condition 自定义条件加载Bean
 */
public class CommonCondition implements Condition {

    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        /** 环境变量及系统属性 */
        Environment env = conditionContext.getEnvironment();

        // systemProperties
        System.out.println("user.dir = " + env.getProperty("user.dir"));
        System.out.println("os.name = " + env.getProperty("os.name"));
        System.out.println("sun.cpu.isalist = " + env.getProperty("sun.cpu.isalist"));

        System.out.println(env.getProperty("path"));

        if (env.getProperty("os.name").contains("Windows")) {
            System.out.println(env.getProperty("os.name"));
        }

        // systemEnvironment
        System.out.println("JAVA_HOME = " + env.getProperty("JAVA_HOME"));


        /** bean 定义 */
        BeanDefinitionRegistry beanDefinitionRegistry = conditionContext.getRegistry();

        /** 检查bean存在、探查bean的属性 */
        ConfigurableListableBeanFactory configurableListableBeanFactory = conditionContext.getBeanFactory();

        /** 加载的资源 */
        ResourceLoader resourceLoader = conditionContext.getResourceLoader();

        /** 类加载器 */
        ClassLoader classLoader = conditionContext.getClassLoader();

        // if(env.containsProperty("test.user.dir")) return false;
        return true;
    }

}
