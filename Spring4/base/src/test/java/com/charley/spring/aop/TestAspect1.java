package com.charley.spring.aop;

import com.charley.spring.aop.config.AopConfig;
import com.charley.spring.aop.within.WithStore1;
import com.charley.spring.aop.within.WithStore2;
import com.charley.spring.aop.within.WithStore3;
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
@ContextConfiguration(classes = AopConfig.class)
public class TestAspect1 {

    private final static Logger log = LoggerFactory.getLogger(TestAspect1.class);

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private WithStore1 withStore1;

    @Autowired
    private WithStore2 withStore2;

    @Autowired
    private WithStore3 withStore3;

    @Test
    public void test1() throws FileNotFoundException {
        Assert.assertNotNull(withStore1);
        System.out.print(withStore1.getInfo());
        Assert.assertEquals("withStore1", systemOutRule.getLog());
        System.out.println(" -------------------------- ");

        // aop test
        withStore1.start();
    }

    /**
     * 测试定义切点
     * @throws FileNotFoundException
     */
    @Test
    public void test2() throws FileNotFoundException {
        Assert.assertNotNull(withStore2);
        withStore2.start();
    }

}
