package com.charley.spring.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    /**
     * @Async 若用在类级别，则表明该类所有的方法都是异步方法
     * @param i
     */
    @Async
    public void executeAsyncTask(Integer i) {
        System.out.println("执行异步任务：" + i);
    }

    @Async
    public  void executeAsyncTaskPlus(Integer i) {
        System.out.println("执行异步任务扩展：" + i);
    }

}
