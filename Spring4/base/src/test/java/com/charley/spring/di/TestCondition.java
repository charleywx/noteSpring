package com.charley.spring.di;


import com.charley.spring.di.bean.Dept;
import com.charley.spring.di.config.ConditionConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConditionConfig.class})
public class TestCondition {

    @Autowired
    private Dept dept;

    @Test
    public void test() {
        Assert.assertNotNull(dept);
        System.out.println(dept.namePub);
    }

}
