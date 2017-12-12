package com.charley.spring.di.main;

import com.charley.spring.di.bean.Dept;
import com.charley.spring.di.bean.Person;
import com.charley.spring.di.config.DefaultConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * 测试类
 */
public class TestUtilPop {

    private final static Logger log = LoggerFactory.getLogger(TestUtilPop.class);
    
    public static void main(String[] args) {
         initSpringByXml();
    }
    
    /**
     * 通过XML加装上下文
     */
    private static void initSpringByXml() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("default.xml");
        Properties p = (Properties) ac.getBean("popBean");
        log.info(p.getProperty("year"));
        log.info(p.getProperty("month"));
        log.info(p.getProperty("day"));
        log.info(p.getProperty("path"));
    }
    
}