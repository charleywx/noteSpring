package com.charley.spring.di;

import com.charley.spring.di.bean.PersonPop;
import com.charley.spring.di.original.PersonOri;
import com.charley.spring.di.original.PersonOriC;
import com.charley.spring.di.original.PersonOriP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration("/default.xml")
public class TestCp {

    private static Logger log = LoggerFactory.getLogger(TestCp.class);

    @Autowired
    private PersonOri personOri;

    @Autowired
    private PersonOriC personOriC;

    @Autowired
    private PersonOriP personOriP;

    @Test
    public void personCIsNull() {
        org.junit.Assert.assertNotNull(personOriC);
        log.info(personOriC.getDeptOri().namePub);
        log.info(personOriC.pName);
        log.info(personOriC.pAge);
        // org.junit.Assert.assertNull(personOriC.pAge);
    }

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

    @Test
    public void personPIsNull() {
        org.junit.Assert.assertNotNull(personOriP);
        log.info(personOriP.getDeptOri().namePub);
        log.info(personOriP.pName);
        log.info(personOriP.pAge);
//        for (String s : personOriP.pList) {
//            log.info(s);
//        }
    }

    @Autowired
    private PersonPop personPop;

    @Test
    public void testPop() {
        org.junit.Assert.assertNotNull(personPop);
    }

}
