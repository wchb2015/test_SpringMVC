package com.springmvc.action;

import com.springmvc.model.Admin;
import com.springmvc.model.User;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wchb7 on 16-5-6.
 */


@org.springframework.stereotype.Controller
public class TestController {

    //http://localhost:8080/test_springmvc/baseType.html?age=10
    //http://localhost:8080/test_springmvc/baseType.html?age=abc 400
    @RequestMapping(value = "/baseType")
    @ResponseBody
    public String baseType(int age) {
        System.out.println("age:" + age);
        return "age:" + age;
    }

    //http://localhost:8080/test_springmvc/baseType2.html
    //http://localhost:8080/test_springmvc/baseType2.html?age=abc 400
    @RequestMapping(value = "baseType2")
    @ResponseBody
    public String baseType2(Integer age) {
        return "age:" + age;
    }

    //http://localhost:8080/test_springmvc/array.html?name=Tom&name=Lucy&name=Jim
    @RequestMapping(value = "array")
    @ResponseBody
    public String array(String[] name){
        StringBuilder sbf = new StringBuilder();
        for(String item : name){
            sbf.append(item).append(" ");
        }
        return sbf.toString();
    }

    //http://localhost:8080/test_springmvc/object.html?username=Tom
    //http://localhost:8080/test_springmvc/object.html?user.username=Tom&admin.username=Lucy
    @RequestMapping(value = "/object")
    @ResponseBody
    public String object(User user, Admin admin){
        return user.toString()+" "+admin.toString();
    }

    @InitBinder("user")
    public void initUser(WebDataBinder binder){
        binder.setFieldDefaultPrefix("user.");
    }
    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder){
        binder.setFieldDefaultPrefix("admin.");
    }
}
