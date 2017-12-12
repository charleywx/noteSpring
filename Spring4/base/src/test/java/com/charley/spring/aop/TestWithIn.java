package com.charley.spring.aop;

import com.charley.spring.aop.config.AopConfigWithin;
import com.charley.spring.aop.within.WithStore1;
import com.charley.spring.aop.within.WithStore2;
import com.charley.spring.aop.within.WithStore3;
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
@ContextConfiguration(classes = AopConfigWithin.class)
public class TestWithIn {

    private final static Logger log = LoggerFactory.getLogger(TestWithIn.class);

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private WithStore1 withStore1;

    @Autowired
    private WithStore2 withStore2;

    @Autowired
    private WithStore3 withStore3;

    @Test
    public void test() throws FileNotFoundException {
        withStore1.start();
        System.out.println(" ---------------------------------- ");
        withStore2.start();
        System.out.println(" ---------------------------------- ");
        withStore3.start(3);
    }

}
