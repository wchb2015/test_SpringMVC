package com.springmvc.service.impl;

import com.springmvc.dao.UserDao;
import com.springmvc.model.User;
import com.springmvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    public int saveUser(User user) {
        LOG.info("UserServiceImpl.saveUser()");
        userDao.insertUser(user);
        return 0;
    }

    public List<User> queryUser(Map params) {
        LOG.info("UserServiceImpl.queryUser()");
        userDao.selectUser(params);
        return null;
    }

    public UserServiceImpl() {
        LOG.info("UserServiceImpl init()");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
