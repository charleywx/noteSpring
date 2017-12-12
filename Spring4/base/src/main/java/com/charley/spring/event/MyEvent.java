package com.charley.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * 继承 ApplicationEvent
 */
public class MyEvent extends ApplicationEvent {

    private String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
