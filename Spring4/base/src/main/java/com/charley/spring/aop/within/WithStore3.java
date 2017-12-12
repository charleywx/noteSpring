package com.charley.spring.aop.within;

import org.springframework.stereotype.Component;

/**
 * 切面实现参数调用
 */
@Component
public class WithStore3 {

    public void start(int num) {
        System.out.println("实体方法 WithStore3 num = " + num);
    }

}
