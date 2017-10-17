package com.springmvc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class User {

    private String username;
    private String passwd;
    private int age;
    private Date createTime;

    public User(String username, String passwd, int age) {
        this.username = username;
        this.passwd = passwd;
        this.age = age;
    }

    public User() {
    }

}
