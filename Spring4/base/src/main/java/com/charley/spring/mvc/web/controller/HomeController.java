package com.charley.spring.mvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Controller = @Component
 * 只是@Controller语义更加明确
 *
 * @RequestMapping({"/", "/homepage"}) 处理多个请求：/和/homepage的请求。
 */
@Controller
//@RequestMapping({"/", "/homepage"})
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    /**
     * URL模版进行重定向
     * @param model
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model) {
        // model.addAllAttributes("userName", "userName");
        return "redirect:/register/{userName}";
    }

}
