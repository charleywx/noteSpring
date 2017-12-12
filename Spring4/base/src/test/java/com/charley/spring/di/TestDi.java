package com.charley.spring.di;

import com.charley.spring.di.bean.Person;
import com.charley.spring.di.original.PersonOri;
import com.charley.spring.di.config.MergeXmlConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * 测试Dependency Injection
 * @Autowired 自动装配，根据类名，与变量名无关
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MergeXmlConfig.class)
public class TestDi {

    private static Logger log = LoggerFactory.getLogger(TestDi.class);

    @Autowired
    private Person testps;

    @Test
    public void testPerson1() {
        assertNotNull(testps);
    }

    @Autowired
    private PersonOri personOri;

    @Test
    public void personIsNull() {
        org.junit.Assert.assertNotNull(personOri);
        log.info(personOri.getDeptOri().namePub);
        log.info(personOri.pName);
        log.info(personOri.pAge);
        // org.junit.Assert.assertNull(personOri.pAge);
        for (String s : personOri.pList) {
            log.info(s);
        }
    }

}
