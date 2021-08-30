package com.demo.ajaxlist.controller;

import com.demo.ajaxlist.form.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @RequestMapping("/index")
    public String showIndexPage(){
        return "hello";
    }

    @RequestMapping(value = "/showRegister_get")
    public String showRegisterPage(){
        return "register_Ajax_get";
    }

    @RequestMapping(value = "/showRegister_post")
    public String showRegisterPage2(){
        return "register_Ajax_post";
    }

    @RequestMapping(value = "/showRegister_common")
    public String showRegisterPage3(){
        return "register_commonAjax";
    }

    @RequestMapping(value = "/showUserAjaxPage")
    public String toUserAjaxPage(Model model){
        model.addAttribute("userBean",new UserBean("zhangsan"));
        return "user_Ajax";
    }

    @RequestMapping(value = "/csvDownloadPage")
    public String showsvDownloadCPage(){
        return "csvDownload";
    }
}
