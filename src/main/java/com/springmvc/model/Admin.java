package com.springmvc.model;

/**
 * Created by wchb7 on 16-5-6.
 */
public class Admin {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                '}';
    }
}
