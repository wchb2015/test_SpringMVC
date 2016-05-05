package com.springmvc.service.impl;

import com.springmvc.dao.UserDao;
import com.springmvc.model.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wchb7 on 16-5-3.
 */

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;


    public int saveUser(User user) {
        System.out.println("___$$$   UserServiceImpl.saveUser()");
        userDao.insertUser(user);
        return 0;
    }

    public List<User> queryUser(Map params) {
        System.out.println("___$$$   UserServiceImpl.queryUser()");
        userDao.selectUser(params);
        return null;
    }

    public UserServiceImpl() {
        System.out.println("___$$$   " + this.getClass().getName() + "   initialize()");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
