package com.charley.spring.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncConfig.class);

        // 两种写法均可
        AsyncService asyncService = (AsyncService) context.getBean("asyncService");
//        AsyncService asyncService = context.getBean(AsyncService.class);
        try {
            for (int i = 0; i < 10; i++) {
                asyncService.executeAsyncTask(i);
                asyncService.executeAsyncTaskPlus(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
