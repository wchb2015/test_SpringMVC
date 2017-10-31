package com.springmvc.action;

import com.springmvc.model.Admin;
import com.springmvc.model.HttpResult;
import com.springmvc.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@org.springframework.stereotype.Controller
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @ResponseBody
    @RequestMapping(value = "/teamIds", method = {RequestMethod.POST, RequestMethod.GET})
    public HttpResult<String> getXXXByTeamIds(@RequestParam("xxx") Long[] teamId) {
        logger.info("teamIds:{}", Arrays.asList(teamId));

        return new HttpResult(200, "success");
    }

    /**
     * 通过@RequestParam对简单类型的参数进行绑定.
     * 如果不使用@RequestParam,要求request传入参数名称和controller方法的形参名称一致,方可绑定成功.
     *
     * @param uriId
     * @param itemId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/test/{uriId}")
    public HttpResult<String> editItems(@PathVariable Long uriId, @RequestParam Integer itemId) {
        logger.info("itemId: {}", itemId);
        logger.info("uriId: {}", uriId);
        return new HttpResult(200, "success!");
    }

    @ResponseBody
    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public String getCurrentTimeStamp() {
        return String.valueOf(System.currentTimeMillis());
    }

    @RequestMapping(value = "/baseType")
    @ResponseBody
    public String baseType(int age) {
        System.out.println("age:" + age);
        return "age:" + age;
    }

    @RequestMapping(value = "baseType2")
    @ResponseBody
    public String baseType2(Integer age) {
        return "age:" + age;
    }

    @RequestMapping(value = "array")
    @ResponseBody
    public String array(String[] name) {
        StringBuilder sbf = new StringBuilder();
        for (String item : name) {
            sbf.append(item).append(" ");
        }
        return sbf.toString();
    }

    @RequestMapping(value = "/object")
    @ResponseBody
    public String object(User user, Admin admin) {
        return user.toString() + " " + admin.toString();
    }

    @InitBinder("user")
    public void initUser(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("admin.");
    }
}
