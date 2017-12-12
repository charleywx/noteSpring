package com.charley.springMvc.web.ch4_5;

import com.charley.springMvc.DemoObj.DemoObj;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


public class ConverterController {
    @RequestMapping(value = "/convert",produces = {"application/x-wisely"})
    public @ResponseBody DemoObj convert(@RequestBody DemoObj demoObj){
        return demoObj;
    }
}
