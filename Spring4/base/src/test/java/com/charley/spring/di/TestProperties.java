package com.charley.spring.di;


import com.charley.spring.di.bean.Dept;
import com.charley.spring.di.bean.DeptGhj;
import com.charley.spring.di.config.PropertyConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用外部属性文件及SpEL
 * 1、占位符表达式
 * 2、SpEL表达式
 */
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PropertyConfig.class})
public class TestProperties {

    @Value("${year}")
    private String year;

    @Value("${month}") String month;

    /**
     * 占位符表达式格式：${...}
     */
    @Test
    public void test() {
        System.out.println(year);
        System.out.println(month);
        // 不可用户方法体内
        // System.out.println(@Value("${month}") String month);
    }

    /**
     * SpEL表达式格式：#{...}
     * T()表达式 引用Java中的类型
     */
    @Value("#{T(System).currentTimeMillis()}")
    private String timeStr;

    /**
     * bean的ID为dept的namePub属性
     */
    @Value("#{dept.namePub}")
    private String namePub;

    /**
     * bean的ID为dept的getSomeString方法
     * ? 为类型安全运算符，如果方法返回null,SpEL将不会调用toUpperCase方法
     */
    @Value("#{dept.getSomeString()?.toUpperCase()}")
    private String someStr;

    /**
     * systemProperties 的属性
     * 错误的引用：systemProperties.os.name
     * 正确方式：systemProperties['...']
     */
    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{systemProperties['disc.title']}")
    private String discTitle;

    @Value("#{systemEnvironment['JAVA_HOME']}")
    private String javaHome;

    @Value("#{'3.14159'}")
    private String num1;
    @Value("#{3.14159}")
    private String num2;
    @Value("#{2E10}")
    private double num3;
    @Value("#{2^10}")
    private double num4;
    @Value("#{true }")
    private boolean num5;

    /**
     * 正则表达式
     */
    @Value("#{'charley@11.com' matches '[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com'}")
    private boolean num6;
    @Value("#{'charley@11' matches '[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com'}")
    private boolean num7;

    /**
     * 集合类
     */
    @Value("#{dept.getList()?.get(3)?.getName()}")
    private String num8;

    /**
     * 集合类
     */
    @Value("#{dept.getList()?.get(3)?.getName()}")
    private String num9;

    /**
     * 集合类
     * dept是单例，上面调用了2次setList方法，加上本次，共3次。
     * 查找运算符表达式：
     * 1、.?[...] 匹配所有的
     * 2、.^[...] 匹配第一个
     * 3、.$[...] 匹配最后一个
     */
    @Value("#{dept.getList().?[name eq 'namePub-New-2'].^[name eq 'namePub-New-2']}")
    private List<DeptGhj> list1;

    /**
     * 投影运算符
     * .![...]
     * 集合中投影出List<String>对象。
     */
    @Value("#{dept.getList().![name]}")
    private List<String> list2;

    /**
     * Spring表达式
     */
    @Test
    public void testSpEL() {
        System.out.println();
        System.out.println("timeStr = " + timeStr);
        System.out.println("namePub = " + namePub);
        System.out.println("someStr = " + someStr);
        System.out.println("osName = " + osName);
        System.out.println("discTitle = " + discTitle);
        System.out.println("javaHome = " + javaHome);
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("num3 = " + num3);
        System.out.println("num3 = " + (long)num3);
        System.out.println("num4 = " + (long)num4);
        System.out.println("num5 = " + num5);
        System.out.println("num6 = " + num6);
        System.out.println("num7 = " + num7);
        System.out.println("num8 = " + num8);
        for (DeptGhj deptGhj : list1) {
            System.out.println("list1: deptGhj.getName() = " + deptGhj.getName());
        }
        for (String name : list2) {
            System.out.println("list2: name = " + name);
        }

    }

}
