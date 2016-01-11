package com.springmvc.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangchongbei on 16-1-7.
 */

/**
 * 1.不应该在Servlet中便宜创建成员变量，因为可能会存在一个线程对这个成员变量进行写操作，另一个线程对这个成员变量进行读操作。
 * 2.不是线程安全的.
 * 3.默认服务器会在某个Servlet第一次收到请求时创建它。
 */

public class TestServletA implements Servlet {

    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("_____________init()");
        ServletContext context = servletConfig.getServletContext();
        context.getContextPath();
        System.out.println(context.getInitParameter("log4jConfigLocation"));
        System.out.println(context.getInitParameter("contextConfigLocation"));


        System.out.println(context.getRealPath("/log4j.properties"));
        System.out.println(context.getRealPath("/WEB-INF/commons-io-2.4.jar"));

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        System.out.println(httpServletRequest.getMethod());
        System.out.println(request.getParameter("aa"));

        System.out.println(this.hashCode() + "_____________service()___" + Thread.currentThread().getName());

        ServletContext context = request.getServletContext();
        System.out.println("_____________count:" + context.getAttribute("count"));
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("_____________destroy()");
    }

   /* protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }*/
}
