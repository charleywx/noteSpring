package com.charley.spring.test;

import com.charley.spring.di.config.PropertyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestProperty {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertyConfig.class);
        TestPropertyBean bean = context.getBean(TestPropertyBean.class);
        bean.testPrint();
    }

}
