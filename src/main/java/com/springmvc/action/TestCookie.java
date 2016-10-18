package com.springmvc.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/cookie")
public class TestCookie {

    private static final Logger LOG = LoggerFactory.getLogger(TestCookie.class);

    @ResponseBody
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("testCookieKey", String.valueOf(System.currentTimeMillis()));
        cookie.setPath("/");
        response.addCookie(cookie);
        return "success!!!";
    }

    @ResponseBody
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String getCookie(@CookieValue("testCookieKey") Long value, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            LOG.warn(System.getProperty("line.separator") + "cookie---comment:{},domain:{},maxAge:{},name:{},value:{},path:{},version:{}"
                    , cookie.getComment(), cookie.getDomain()
                    , cookie.getMaxAge(), cookie.getName(), cookie.getValue()
                    , cookie.getPath(), cookie.getVersion());
        }

        return value + "_" + cookies.length;
    }
}
