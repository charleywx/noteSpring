package com.charley.spring.di;

import com.charley.spring.di.bean.Dept;
import com.charley.spring.di.config.ProfileConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

/**
 * @ActiveProfiles("test") dept1、dept2 = @Profile("test") 的bean
 * @ActiveProfiles("dev") dept1、dept2 = @Profile("dev") 的bean
 * 无@ActiveProfiles     dept1、dept2 = 无@Profile 的bean
 */
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProfileConfig.class)
//@ContextConfiguration("/appTestProfile.xml")
@ActiveProfiles("test")
public class TestProfile {

    @Autowired
    private Dept dept1;

    @Autowired
    private Dept dept2;

//    @Autowired
//    private Dept dept3;

    /**
     * test1 和 test2 执行只有是相同的结果
     * dept1、dept2 引用的是相同的对象
     */
    @Test
    public void test() {
        Assert.assertEquals(dept1, dept2);
    }

    @Test
    public void test1() {
        Assert.assertNotNull(dept1);
        System.out.println(dept1.namePub);
    }

    @Test
    public void test2() {
        Assert.assertNotNull(dept2);
        System.out.println(dept2.namePub);
    }

//    @Test
//    public void test3() {
//        Assert.assertNotNull(dept3);
//        System.out.println(dept3.namePub);
//    }

}
