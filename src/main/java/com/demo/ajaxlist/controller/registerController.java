package com.demo.ajaxlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class registerController {
    @RequestMapping("/register")
    public String registerHandle(@ModelAttribute("username") String username){
        System.out.println("username = "+username);
        String result = "<font color='green'><b>用户名可用!</b></font>";
        if("zhangsan".equals(username) || "luo".equals(username)){
            result = "<font color='red'><b>用户名已注册!</b></font>";
        }
        return result;
    }
}
