package com.springmvc.action;

import com.springmvc.model.HttpResult;
import com.springmvc.model.PageData;
import com.springmvc.model.User;
import com.springmvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/user-module")
public class UserController {

    private Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public HttpResult<PageData<User>> getUsers() throws Exception {

        List<User> userList = new ArrayList<User>();

        User u1 = new User("aaa", "123", 1);
        User u2 = new User("bbb", "123", 1);
        User u3 = new User("ccc", "123", 1);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);

        return HttpResult.success(new PageData<User>(100L, userList));
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
