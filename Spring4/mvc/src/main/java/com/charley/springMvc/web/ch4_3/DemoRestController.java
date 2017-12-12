package com.charley.springMvc.web.ch4_3;

import com.charley.springMvc.DemoObj.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * on 2017/11/8.
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {
    @RequestMapping(value = "getjson",produces = {"application/json;charset=UTF-8"})
    public DemoObj getjson(DemoObj obj){
        String name =  obj.getName();
        return new DemoObj(obj.getId()+1,obj.getName()+"yy");
    }

    @RequestMapping(value = "getxml",produces = {"application/xml;charset=UTF-8"})
    public DemoObj getxml(DemoObj obj){
        return new DemoObj(obj.getId()+1,obj.getName()+"yy");
    }
}
