package com.charley.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("anno")
public class DemoAnnoController {

    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request) {
        return "url : " + request.getRequestURL() + " 可以连接";
    }

    @RequestMapping(value = "pathvar/${str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request) {
        return "url : " + request.getRequestURL() + " 可以连接，str = " + str;
    }

    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id, HttpServletRequest request) {
        return "url : " + request.getRequestURL() + " 可以连接，id = " + id;
    }

}
