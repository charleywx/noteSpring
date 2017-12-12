package com.charley.spring.di.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Component 标记为组件
 * @Component("person") 标记为组件,bean的ID="person"
 * @Autowired 自动装配注解是根据类名进行注入，若有多个则根据参数查找bean的ID
 * @Autowired 可以用在构造方法、set方法、成员变量、其他方法。自动装配在引用上下文时被执行。
 * @Qualifier("person")
 */
@Component("person")
public class Person {

    private String name;

    @Autowired
    private Dept dept;
    
    public Person() {
    
    }

    public Person(String string, String name) {
    }

    public Dept getDept() {
        return dept;
    }

//    @Autowired
//    PersonOri(DeptOri dept) {
//        this.dept = dept;
//    }

    /**
     * @Autowired 自动装配
     * @param dept
     */
//    @Autowired
//    public void setDeptOri(DeptOri dept) {
//        this.dept = dept;
//    }

//    @Autowired
//    public void otherMethod(DeptOri dept) {
//        this.dept = dept;
//    }

    @Autowired(required = false)
    public void otherMethod(Dept dept) {
        this.dept = dept;
    }
}
