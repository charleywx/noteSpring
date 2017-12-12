package com.charley.spring.di;

import com.charley.spring.di.bean.Jsr250;
import com.charley.spring.di.bean.Jsr250Bean;
import com.charley.spring.di.bean.PersonPop;
import com.charley.spring.di.config.QualifierConfig;
import com.charley.spring.di.original.PersonOri;
import com.charley.spring.di.original.PersonOriC;
import com.charley.spring.di.original.PersonOriP;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = QualifierConfig.class)
public class TestJsr250 {

    private static Logger log = LoggerFactory.getLogger(TestJsr250.class);

    @Test
    public void test() {
    }

}
