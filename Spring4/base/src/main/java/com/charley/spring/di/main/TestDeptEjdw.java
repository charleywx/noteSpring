package com.charley.spring.di.main;

import com.charley.spring.di.bean.DeptEjdw;
import com.charley.spring.di.bean.DeptTestBean;
import com.charley.spring.di.config.DefaultConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDeptEjdw {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DefaultConfig.class);
        DeptTestBean deptTestBean = applicationContext.getBean(DeptTestBean.class);

        System.out.println(deptTestBean.deptEjdw.getName());
    }
}
