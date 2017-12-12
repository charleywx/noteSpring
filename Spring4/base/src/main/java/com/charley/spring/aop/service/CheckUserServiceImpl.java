package com.charley.spring.aop.service;

import com.charley.spring.aop.bean.User;

public class CheckUserServiceImpl implements CheckUserService {

    public boolean check(User user) {
        if(user != null && user.getUserName().equals("admin") && user.getPossword().equals("111")) {
            return true;
        }
        return false;
    }

}
