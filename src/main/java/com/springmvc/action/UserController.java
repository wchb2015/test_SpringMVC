package com.springmvc.action;


import com.springmvc.model.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangchongbei on 16-1-26.
 */


@org.springframework.stereotype.Controller
@RequestMapping("/user-module")
public class UserController {

    @Autowired
    private UserService userService;

//http://localhost:8080/test_springmvc/user-module/getAllUsers.html
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public String getUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<User> userList = new ArrayList<User>();

        User u1 = new User("aaa", "123", 1);
        User u2 = new User("bbb", "123", 1);
        User u3 = new User("ccc", "123", 1);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);

        request.setAttribute("userList", userList);

        userService.queryUser(null);

        return "userList";

       /* ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("userList", userList);//相当于request的setAttribute,在jsp页面中通过userList取数据

        modelAndView.setViewName("userList"); //指定视图*/

    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserController() {
        System.out.println("___$$$   " + this.getClass().getName() + "   initialize()");
    }
}
