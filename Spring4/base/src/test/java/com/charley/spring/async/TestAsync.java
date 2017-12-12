package com.charley.spring.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * 异步测试
 */
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AsyncConfig.class})
public class TestAsync {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void test() {
        for (int i = 0; i < 20; i++) {
            asyncService.executeAsyncTask(i);
            asyncService.executeAsyncTaskPlus(i);
        }
    }

}
