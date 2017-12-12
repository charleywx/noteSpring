package com.charley.spring.aop;

import com.charley.spring.aop.config.AopConfig;
import com.charley.spring.aop.within.WithStore1;
import com.charley.spring.aop.within.WithStore2;
import com.charley.spring.aop.within.WithStore3;
import com.charley.spring.aop.xml.DeclareBasic;
import com.charley.spring.aop.xml.DeclareImpl;
import com.charley.spring.aop.xml.Store;
import com.charley.spring.aop.xml.StorePrivate;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.io.FileNotFoundException;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration("/aop.xml")
public class TestAopXml {

    private final static Logger log = LoggerFactory.getLogger(TestAopXml.class);

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private Store store;

    @Test
    public void test1(){
        store.getStore();
    }

    /**
     * 参数的传递
     */
    @Test
    public void test2(){
        store.getStore2("charley");
    }

    @Autowired
    private DeclareBasic declareBasic;

    /**
     * 引入新功能
     */
    @Test
    public void test3(){
        /**
         * 将 store 强制转换为 Declare 类
         */
        DeclareBasic s = (DeclareBasic)store;
        s.start();
        store.getStore();

        StorePrivate ss = new StorePrivate();
        ss.getStore4();
    }

}
