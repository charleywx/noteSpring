package com.charley.spring.aop;

import com.charley.spring.aop.config.AopConfig;
import com.charley.spring.aop.within.WithStore2;
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
public class TestAround {

    private final static Logger log = LoggerFactory.getLogger(TestAround.class);

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private WithStore2 withStore2;

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
