package com.charley.spring.aop;

import com.charley.spring.aop.bean.User;
import com.charley.spring.aop.config.AopConfig;
import com.charley.spring.aop.config.AopDeclare;
import com.charley.spring.aop.service.CheckUserService;
import com.charley.spring.aop.service.UserIf;
import com.charley.spring.aop.service.UserLogin;
import com.charley.spring.aop.service.UserLoginImpl;
import com.charley.spring.aop.within.WithStore2;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.io.FileNotFoundException;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AopDeclare.class)
public class TestDeclare {

    private final static Logger log = LoggerFactory.getLogger(TestDeclare.class);

    @Autowired
    private UserLogin userLogin;

    @Autowired
    private UserLoginImpl userLoginImpl;

    @Autowired
    private UserIf userIf;

    @Test
    public void test1() {
        // 通过类型转换，userLogin对象就拥有了CheckUserService 类的方法
        CheckUserService cus = (CheckUserService) userLogin;
        User user = new User();
        user.setUserName("admin");
        user.setPossword("111");
        if(cus.check(user)) {
            userLogin.login();
        }
    }

    @Test
    public void test2() {
        // 通过类型转换，userLogin对象就拥有了CheckUserService 类的方法
        CheckUserService cus = (CheckUserService) userLoginImpl;
        User user = new User();
        user.setUserName("admin");
        user.setPossword("111");
        if(cus.check(user)) {
            userLoginImpl.login();
        }
    }

    @Test
    public void test3() {
        // 通过类型转换，userLogin对象就拥有了CheckUserService 类的方法
        CheckUserService cus = (CheckUserService) userIf;
        User user = new User();
        user.setUserName("admin");
        user.setPossword("111");
        if(cus.check(user)) {
            userIf.login();
        }
    }

}
