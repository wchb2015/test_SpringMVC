package com.springmvc.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by wangchongbei on 16-1-7.
 */
public class TestServletC extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getContentLength();
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("passwd"));

        Enumeration names = request.getParameterNames();// 获取所有参数名称
        while (names.hasMoreElements()) {
            System.out.println("_________" + names.nextElement());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* response.setStatus(302);
        response.setHeader("Location", "http://www.baidu.cn");*/

        request.getHeaderNames();
        request.getContentLength();//获取请求体的字节数,GET请求没有请求体，没有请求体返回 - 1;
//        response.sendRedirect("http://www.baidu.cn");
        System.out.println("request.getContentLength(): " + request.getContentLength());
        System.out.println("request.getContentType(): " + request.getContentType());
        System.out.println("request.getContextPath(): " + request.getContextPath());
        System.out.println("request.getMethod(): " + request.getMethod());
        System.out.println("request.getLocale(): " + request.getLocale());

        System.out.println("request.getQueryString(): " + request.getQueryString());
        System.out.println("request.getRequestURI(): " + request.getRequestURI());
        System.out.println("request.getRequestURL(): " + request.getRequestURL());
        System.out.println("request.getServletPath(): " + request.getServletPath());
        System.out.println("request.getRemoteAddr(): " + request.getRemoteAddr());
        System.out.println("request.getRemoteHost(): " + request.getRemoteHost());
        System.out.println("request.getRemotePort(): " + request.getRemotePort());
        System.out.println("request.getScheme(): " + request.getScheme());
        System.out.println("request.getServerName(): " + request.getServerName());
        System.out.println("request.getServerPort(): " + request.getServerPort());


        response.sendRedirect("/test_springmvc/index.jsp");
        // 以“/”开头，相对主机，与当前a.html的主机相同，即最终访问的页面为http://localhost:8080/hello2/index.html；
    }
}
