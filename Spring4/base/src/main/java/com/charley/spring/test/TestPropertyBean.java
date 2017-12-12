package com.charley.spring.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestPropertyBean {

    @Value("${year}")
    private String year;

    // 没有month1属性时，month1="${month1}"字面量
    @Value("${month1}")
    private String month1;

    // 没有testBl属性时，spring加载时报错
//    @Value("${testBl}")
//    private boolean testBl = false;

    // Boolean 申明 testBl=null
    @Value("#{environment.testBl}")
    private Boolean testBl=false;

    // 构造器里面的没有值
    TestPropertyBean() {
        System.out.println(year);
        System.out.println(month1);
    }

    public void testPrint() {
        System.out.println(year);
        System.out.println(month1);
        System.out.println(testBl);

        // java.lang.NullPointerException
        if(testBl) {
            System.out.println("testBl is true");
        } else{
            System.out.println("testBl is false");
        }
    }

}
