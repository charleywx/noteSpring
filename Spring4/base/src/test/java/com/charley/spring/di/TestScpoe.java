package com.charley.spring.di;


import com.charley.spring.di.config.ScopeConfig;
import com.charley.spring.di.scope.Notepad;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ScopeConfig.class})
public class TestScpoe {

    @Autowired
    private Notepad notepad1;

    @Autowired
    private Notepad notepad2;

    /**
     * 单例模式下返回：true
     * 原型模式下放回：false
     */
    @Test
    public void test() {
        Assert.assertEquals(notepad1, notepad2);
    }

}
