package com.charley.spring.di;


import com.charley.spring.di.annotation.MyAnnotation;
import com.charley.spring.di.bean.DeptEjdw;
import com.charley.spring.di.config.QualifierConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {QualifierConfig.class})
public class TestQualifier {

    /**
     * 可选择性的调用
     */
    @Autowired
//    @Qualifier("ghj")
//    @Qualifier("kgc")
    @MyAnnotation
    private DeptEjdw deptEjdw;

    @Test
    public void test() {
        Assert.assertNotNull(deptEjdw);
        System.out.println(deptEjdw.getName());
    }

}
