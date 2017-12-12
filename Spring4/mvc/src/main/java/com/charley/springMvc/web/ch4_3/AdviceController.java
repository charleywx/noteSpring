package com.charley.springMvc.web.ch4_3;

import com.charley.springMvc.DemoObj.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ModelAttribute 全局变量
 * <p>
 * http://localhost:8080/advice
 * 参数异常来自 @ModelAttribute额外信息
 * <p>
 * http://localhost:8080/advice?msg='111'
 */
@Controller
public class AdviceController {

    @RequestMapping(value = "/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj) {
        System.out.println(" msg = " + msg);
        throw new IllegalArgumentException("参数异常" + "来自 @ModelAttribute" + msg);
    }

}
