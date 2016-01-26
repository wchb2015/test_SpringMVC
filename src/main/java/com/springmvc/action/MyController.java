package com.springmvc.action;


import com.springmvc.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/myController")
public class MyController implements Controller {


    @RequestMapping("1.html")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<User> userList = new ArrayList<User>();
        User u1 = new User("aaa", "123", 1);
        User u2 = new User("bbb", "123", 1);
        User u3 = new User("ccc", "123", 1);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("userList", userList);//相当于request的setAttribute,在jsp页面中通过userList取数据


        modelAndView.setViewName("/WEB-INF/pages/userList.jsp"); //指定视图

        return modelAndView;

    }
}
