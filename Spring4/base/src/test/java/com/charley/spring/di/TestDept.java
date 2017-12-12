package com.charley.spring.di;

import com.charley.spring.di.bean.Dept;
import com.charley.spring.di.bean.Person;
import com.charley.spring.di.config.DeptConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DeptConfig.class})
public class TestDept {

    @Autowired
    private Dept dept;
    
    @Autowired
    private Person person;
    
    @Test
    public void test() {
        System.out.println(dept.namePub);
        Dept dept1 = new Dept();
        Dept dept2 = new Dept();
        if(dept1 == dept) {
            System.out.println("111");
        }
        if(dept1 == dept2) {
            System.out.println("111");
        }
    }
    
    @Test
    public void test1() {
        System.out.println(person.getDept().namePub);
        Person p1 = new Person();
        Person p2 = new Person();
        Dept d1 = person.getDept();
        Dept d2 = p1.getDept();
        Dept d3 = p2.getDept();
        if(d1 == d2) {
            System.out.println("111");
        }
        if(d1 == d3) {
            System.out.println("111");
        }
        if(d2 == d3) {
            System.out.println("111");
        }
    }

}
