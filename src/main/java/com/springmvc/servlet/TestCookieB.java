package com.springmvc.servlet;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestCookieB extends HttpServlet {
    static final Log LOG = LogFactory.getLog(TestCookieB.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("741852" + Thread.currentThread().getName());
        Cookie[] cookies = request.getCookies();
        String msg = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + "______________" + cookie.getValue());
                if (cookie.getName().equals("lastTime")) {
                    msg = "您上次的访问时间是：" + cookie.getValue();
                }
            }
        }

        if (StringUtils.isEmpty(msg)) {
            msg = "您是第一次登陆~!";
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(msg);
    }
}
