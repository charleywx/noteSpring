package com.charley.spring.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.charley.spring.event.EventConfig.class})
public class TestEvent {

    @Autowired
    private MyPublish myPublish;

    @Test
    public void test() {
        myPublish.publish("Hello Event!");
    }

}
