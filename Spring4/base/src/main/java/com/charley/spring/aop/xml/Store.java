package com.charley.spring.aop.xml;

import org.springframework.stereotype.Component;

@Component
public class Store {

    /**
     * AOP 切点必须为public的
     */
    public void getStore() {
        System.out.println("Store.getStore");
    }

    /**
     * 带参数的情况
     * @param name
     */
    public void getStore2(String name) {
        System.out.println("Store.getStore2... and name = " + name);
    }

    /**
     * private 方法不能设置为切点，因为private仅在类的内部可见
     */
    private void getStore1() {
        System.out.println("Store.getStore");
    }

}
