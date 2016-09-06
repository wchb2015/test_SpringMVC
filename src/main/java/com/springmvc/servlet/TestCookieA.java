package com.springmvc.servlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class TestCookieA extends HttpServlet {
    static final Log LOG = LogFactory.getLog(TestCookieA.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("#####" + Thread.currentThread().getName());
        String id = UUID.randomUUID().toString();
        Cookie testCookie = new Cookie("testCookie", id);
        Cookie lastTime = new Cookie("lastTime", new Date().toString());

        resp.addCookie(testCookie);
        resp.addCookie(lastTime);

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print("已经给你发送了Cookie!");


    }
}
