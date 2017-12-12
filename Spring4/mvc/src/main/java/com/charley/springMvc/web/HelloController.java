package com.charley.springMvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * on 2017/11/6.
 */
@Controller
public class HelloController {

        @RequestMapping("/index1")
        public String hello() {
            return "index";
        }

}
