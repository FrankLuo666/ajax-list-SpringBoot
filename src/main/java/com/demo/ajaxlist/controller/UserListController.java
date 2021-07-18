package com.demo.ajaxlist.controller;

import com.demo.ajaxlist.form.UserForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class UserListController {

    @RequestMapping("/showList")
    public String initUserListPage(@ModelAttribute("userForm") UserForm userForm,
       ModelMap modelMap){

        //should search DB; just for test;
        int piecesNumber = 150;
        int fee = piecesNumber * 200;

        //create User
        UserForm user1 = new UserForm("12364","张三","23","医生");
        UserForm user2 = new UserForm("23473","李四","24","律师");
        UserForm user3 = new UserForm("56782","王五","25","议员");
        List<UserForm> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userForm.setUserList(userList);

        modelMap.addAttribute("piecesNumber", piecesNumber);
        modelMap.addAttribute("fee", fee);

        return "userList_Ajax";
    }

    /**
     * to pre page
     * @param userForm
     * @param modelMap
     * @return String
     */
    @RequestMapping(value = "/userList", params = "before")
    public String addUserList(@ModelAttribute("userForm") UserForm userForm,
          @ModelAttribute("fee") String fee,
          @ModelAttribute("piecesNumber") String piecesNumber,ModelMap modelMap, Model model){
        modelMap.addAttribute("piecesNumber", piecesNumber);
        modelMap.addAttribute("fee", fee);
        model.addAttribute("userForm", userForm);

        return "hello";
    }

    /**
     * to next page
     * @param userForm
     * @return String
     */
    @RequestMapping(value = "/userList", params = "next")
    public String deleteUserList(@ModelAttribute("fee") String fee,
        @ModelAttribute("piecesNumber") String piecesNumber,
        @ModelAttribute("userForm") UserForm userForm){

        return "complete";
    }

    /**
     * to next page
     * @param userForm
     * @return String
     */
    @RequestMapping(value = "/userList", params = "refresh")
    public String refreshPage(@ModelAttribute("fee") String fee,
         @ModelAttribute("piecesNumber") String piecesNumber,
         @ModelAttribute("userForm") UserForm userForm){

        return "userList_Ajax";
    }
}
