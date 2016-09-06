package com.springmvc.service;

import com.springmvc.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {

    int saveUser(User user);

    List<User> queryUser(Map params);


}
