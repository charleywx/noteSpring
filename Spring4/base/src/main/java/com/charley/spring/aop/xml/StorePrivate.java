package com.charley.spring.aop.xml;

/**
    java的访问控制是停留在编译层
 */
public class StorePrivate {

    /**
     * private 方法不能设置为切点，因为private仅在类的内部可见，实现类不可见
     */
    private void getStore1() {
        System.out.println("Store.getStore");
    }

    /**
     * protected 方法不能设置为切点，因为protected仅在类及类的子类可见，实现类不可见
     */
    protected void getStore2() {
        System.out.println("Store.getStore2");
    }

    /**
     * default 方法不能设置为切点，因为default仅在本包可见，实现类不可见
     */
    void getStore3() {
        System.out.println("Store.getStore3");
    }

    /**
     * 切点必须为public方法
     */
    public void getStore4() {
        System.out.println("Store.getStore3");
    }

}
