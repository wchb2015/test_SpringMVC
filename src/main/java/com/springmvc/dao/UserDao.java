package com.springmvc.dao;

import com.springmvc.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wchb7 on 16-5-3.
 */
@Repository
public class UserDao {

    public int insertUser(User user) {
        System.out.println("___$$$   UserDao.inserUser()");
        return 0;
    }

    public List<User> selectUser(Map params) {
        System.out.println("___$$$   UserDao.selectUser()");
        return null;
    }
}
