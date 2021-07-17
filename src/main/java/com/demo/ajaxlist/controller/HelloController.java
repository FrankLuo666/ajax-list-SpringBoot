package com.demo.ajaxlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @RequestMapping("/index")
    public String showIndexPage(){
        return "hello";
    }

    @RequestMapping("/showRegisterPage")
    public String showRegisterPage(){
        return "register_AjaxJquery";
    }
}
