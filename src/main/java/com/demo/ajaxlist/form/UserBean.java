package com.demo.ajaxlist.form;

import lombok.Data;

@Data
public class UserBean {
    String username;
    String age;
    String title;

    public UserBean() {
    }

    public UserBean(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "username='" + username + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
