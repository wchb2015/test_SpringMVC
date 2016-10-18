package com.springmvc.dao;

import com.springmvc.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    public int insertUser(User user) {
        System.out.println("741852   UserDao.InsertUser()");
        return 0;
    }

    public List<User> selectUser(Map params) {
        System.out.println("741852   UserDao.selectUser()");
        return null;
    }

    public UserDao() {
        System.out.println("741852   " + this.getClass().getName() + "   initialize()");
    }
}
