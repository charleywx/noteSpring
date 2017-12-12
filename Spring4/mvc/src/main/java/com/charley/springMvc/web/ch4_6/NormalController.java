package com.charley.springMvc.web.ch4_6;

import com.charley.springMvc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * on 2017/11/9.
 */
@Controller
public class NormalController {
    @Autowired
    DemoService demoService;

    @RequestMapping("/normal")
    public String testPage(Model model){
        model.addAttribute("msg",demoService.saySomething());
        return "page";
    }
}
