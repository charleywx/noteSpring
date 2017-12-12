package com.charley.springMvc.web.ch4_3;

import com.charley.springMvc.DemoObj.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/anno")//访问路径
public class DemoAnnoController {

    //

    /**
     * 返回的媒体类型  和数据格式
     * http://localhost:8080/anno
     * @param request
     * @return url:http://localhost:8080/annocan access
     */
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request){
        return "url:"+request.getRequestURL() + "can access";
    }

    /**
     * http://localhost:8080/anno/pathvar/test88
     * @param str
     * @param request
     * @return url:http://localhost:8080/anno/pathvar/test88can access ,str:test88
     */
    @RequestMapping(value = "/pathvar/{str}",produces =
    "text/plain;charset=UTF-8")
    public @ResponseBody String demoPathVar(@PathVariable String str,
                                         HttpServletRequest request   ){
        return "url:"+request.getRequestURL() + "can access ,str:"+str;
    }

    /**
     * http://localhost:8080/anno/requestParam?id=1234
     * @param id
     * @param request
     * @return url:http://localhost:8080/anno/requestParam can access ,id 1234
     */
    @RequestMapping(value = "/requestParam",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id,HttpServletRequest request){
        return "url:" + request.getRequestURL() + " can access ,id " + id;
    }

    @RequestMapping(value = "/obj",produces = "application/json;charsetUTF-8")
    @ResponseBody
    public String passObj(DemoObj obj ,HttpServletRequest request){
        return "url:" + request.getRequestURL() + "can access ,obj id :"+ obj.getId() +
                "obj name :" + obj.getName();
    }

    //{"/name","/name2"}   "/name"
    @RequestMapping(value = {"/name1","/name2"},produces =
            "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request){
        return "url:"+ request.getRequestURL() + " can access";
    }


 }
