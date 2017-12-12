package com.charley.springMvc.web.ch4_5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * 服务器端推送技术
 */
@Controller
public class SseController {

    /**
     * 媒体类型为event-stream
     * @return
     */
    @RequestMapping(value = "/push", produces = "text/event-stream")
    @ResponseBody
    public String push() {
        Random random = new Random();
        try {
            Thread.sleep(5000);
            //TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3" + random.nextInt() + "\n\n";
    }

}
