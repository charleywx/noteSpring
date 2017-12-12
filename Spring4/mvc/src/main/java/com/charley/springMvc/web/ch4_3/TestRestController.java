package com.charley.springMvc.web.ch4_3;

import com.charley.springMvc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController =  @ResponseBody + @Controller
 */
@RestController
//@ResponseBody
//@Controller
public class TestRestController {

    @Autowired
    DemoService demoService;

    public TestRestController() {
    }

    @RequestMapping(value = {"testRest"}, produces = {"text/plain;charset=UTF-8"})
    public String testRest() {
        return this.demoService.saySomething();
    }

}
