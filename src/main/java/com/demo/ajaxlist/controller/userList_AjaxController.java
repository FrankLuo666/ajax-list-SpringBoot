package com.demo.ajaxlist.controller;

import com.demo.ajaxlist.form.UserForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class userList_AjaxController {

    /**
     * add
     * @return
     */
    @PostMapping(value = "/addUser")
    public List<UserForm> addUserList(@RequestBody List<UserForm> userList){
        System.out.println(userList.toString());
        if(userList != null){
            userList.add(new UserForm());
        }

        return userList;
    }

    /**
     * delete
     * @param list
     * @param modelMap
     * @return String
     */
    @RequestMapping(value = "/deleteUser")
    public String deleteUserList(@ModelAttribute("list") List list,
     ModelMap modelMap){
        /*List<UserForm> list = userForm.getUserList();
        if(list == null){
            return "userList";
        }
        if(list.size() >0){
            list.remove(list.size()-1);
        }else{
            log.info("不能再减了!");
        }
        userForm.setUserList(list);
        modelMap.addAttribute("userForm", userForm);*/

        return "userList_Ajax";
    }

    /*@PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) {

        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);

        }

        List<User> users = userService.findByUserNameOrEmail(search.getUsername());
        if (users.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(users);

        return ResponseEntity.ok(result);

    }*/
}
