package com.springmvc.model;

import java.util.Date;

/**
 * Created by wangchongbei on 16-1-8.
 */
public class User {

    private String username;
    private String passwd;
    private int age;
    private Date createTime;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User(String username, String passwd, int age) {
        this.username = username;
        this.passwd = passwd;
        this.age = age;
    }
}
