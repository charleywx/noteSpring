package com.charley.spring.mvc.web.bean;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制器通知类为全局控制器类添加了通知
 * 定义控制器类，@ControllerAdvice本身带有@Component注解的类一样
 * ControllerAdvice 将所有的@ExceptionHandler方法收集到一个类中，这样所有的控制器的异常就能在一个地方进行一致的处理
 */
@ControllerAdvice
public class MyControllerAdvice {

    /**
     * 任意控制器方法抛出了NullPointerException，不管这个方法位于哪个控制器中，都会调用这个nullPointer方法来处理异常
     * @return "error/null"作为逻辑视图名
     */
    @ExceptionHandler(NullPointerException.class)
    public String nullPointer() {
        return "error/null";
    }

}
