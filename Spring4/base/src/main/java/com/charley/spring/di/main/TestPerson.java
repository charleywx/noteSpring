package com.charley.spring.di.main;

import com.charley.spring.di.bean.Dept;
import com.charley.spring.di.bean.Person;
import com.charley.spring.di.config.DefaultConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class TestPerson {
    
    public static void main(String[] args) {
        // initSpringByXml();
        initSpringByJavaConfig();
    }
    
    /**
     * 通过JAVA配置加装上下文
     */
    private static void initSpringByJavaConfig() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DefaultConfig.class);
        
        Person p = (Person) ac.getBean("person");
        Dept dept = p.getDept();
        System.out.println(dept.namePub);
        
        System.out.println("ac.getId() = " + ac.getId());
        System.out.println("ac.getApplicationName() = " + ac.getApplicationName());
        System.out.println("ac.getDisplayName() = " + ac.getDisplayName());
        System.out.println("ac.getStartupDate() = " + ac.getStartupDate());
        
        System.out.println("ac.getParent() = " + ac.getParent());
    }
    
    /**
     * 通过XML加装上下文
     */
    private static void initSpringByXml() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("/default.xml");
        ac.getId();
        System.out.println(ac.getId());
    }
    
}