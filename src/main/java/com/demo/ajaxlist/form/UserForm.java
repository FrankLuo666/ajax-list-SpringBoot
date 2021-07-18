package com.demo.ajaxlist.form;

import lombok.Data;

import java.util.List;

@Data
public class UserForm {
    public UserForm() {
    }

    public UserForm(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public UserForm(String id, String name, String age, String career) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.career = career;
    }

    public UserForm(String id, String name, String age, String career, List<UserForm> userFormList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.career = career;
        this.userList = userFormList;
    }

    private String id;
    private String name;
    private String age;
    private String career;

    private List<UserForm> userList;

    @Override
    public String toString() {
        return "UserForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", career='" + career + '\'' +
                ", userList=" + userList +
                '}';
    }
}
