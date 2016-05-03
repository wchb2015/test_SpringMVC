package com.springmvc.service;

import com.springmvc.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wchb7 on 16-5-3.
 */
@Service
public interface UserService {

    int saveUser(User user);

    List<User> queryUser(Map params);


}
