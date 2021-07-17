package com.demo.ajaxlist.controller;

import com.demo.ajaxlist.form.UserForm;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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

        //for test
        int piecesNumber = 240;
        int fee = piecesNumber * 1000;

        //create User
        UserForm user1 = new UserForm("12364","张三","23","医生");
        UserForm user2 = new UserForm("23473","李四","24","律师");
        UserForm user3 = new UserForm("56782","王五","25","议员");
        List<UserForm> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userForm.setUserList(userList);
        modelMap.addAttribute("userForm", userForm);
        modelMap.addAttribute("piecesNumber", piecesNumber);
        modelMap.addAttribute("fee", fee);

        return "userList";
    }

    /**
     * add
     * @param userForm
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/userList", params = "add")
    public String addUserList(@ModelAttribute("userForm") UserForm userForm,
                              @ModelAttribute("fee") String fee,
                              @ModelAttribute("piecesNumber") String piecesNumber,ModelMap modelMap, Model model){
        List<UserForm> list = userForm.getUserList();
        if(list == null){
            list = new ArrayList<>();
        }
        if(list.size() < Integer.parseInt(piecesNumber)){
            list.add(new UserForm());
        }else{
            log.info("已到达最大件数.");
        }
        userForm.setUserList(list);
        model.addAttribute("userForm", userForm);

        return "userList";
    }

    /**
     * delete
     * @param userForm
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/userList", params = "delete")
    public String deleteUserList(@ModelAttribute("fee") String fee,
        @ModelAttribute("piecesNumber") String piecesNumber,
        @ModelAttribute("userForm") UserForm userForm,
                                   ModelMap modelMap){
        List<UserForm> list = userForm.getUserList();
        if(list == null){
            return "userList";
        }
        if(list.size() >0){
            list.remove(list.size()-1);
        }else{
            log.info("不能再减了!");
        }
        userForm.setUserList(list);
        modelMap.addAttribute("userForm", userForm);

        return "userList";
    }
}
