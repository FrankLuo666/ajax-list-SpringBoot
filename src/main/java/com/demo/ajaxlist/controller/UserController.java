package com.demo.ajaxlist.controller;

import com.demo.ajaxlist.form.UserBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserController extends HttpServlet {

    /**
     * test JSON
     * @return userBean
     */
    @PostMapping(value = "/userAjax")
    public UserBean addUserList(@RequestBody UserBean user){
        System.out.println(user.toString());

        return user;
    }
}