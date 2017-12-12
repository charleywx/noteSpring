package com.charley.spring.di;

import com.charley.spring.di.bean.DeptEjdw;
import com.charley.spring.di.config.ManualConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * 手工注入BEAN
 */
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ManualConfig.class})
public class TestManualBean {

    @Autowired
    private DeptEjdw djdw;

    @Test
    public void beanIsNull(){
        Assert.assertNotNull(djdw);
    }
}
