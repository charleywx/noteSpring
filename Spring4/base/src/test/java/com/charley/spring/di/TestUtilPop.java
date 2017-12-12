package com.charley.spring.di;

import com.charley.spring.di.bean.PersonPop;
import com.charley.spring.di.config.DefaultConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DefaultConfig.class)
public class TestUtilPop {

    private final static Logger log = LoggerFactory.getLogger(TestUtilPop.class);

    @Autowired
    private PersonPop personPop;

    @Test
    public void testPop() {
        org.junit.Assert.assertNotNull(personPop);
        log.info(personPop.pName);
        log.info(personPop.pAge);
    }

}
