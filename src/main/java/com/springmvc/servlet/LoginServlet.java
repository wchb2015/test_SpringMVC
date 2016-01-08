package com.springmvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by wangchongbei on 16-1-8.
 */

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getContentLength();
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");



        Enumeration names = request.getParameterNames();// 获取所有参数名称
        while (names.hasMoreElements()) {
            System.out.println("_________" + names.nextElement());
        }

        response.setContentType("text/html;charset=utf-8");

        if ("admin".equals(username) && "111111".equals(passwd)) {
            response.getWriter().print("登录成功～！");
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            session.getMaxInactiveInterval();//获取session可以的最大不活动时间（秒），默认为30分钟。当session在30分钟内没有使用，那么Tomcat会在session池中移除这个session；

            //response.encodeURL("url")会判断客户端浏览器是否禁用了Cookie，如果禁用了，那么这个方法在URL后面追加jsessionid，否则不会追加。
            response.encodeURL("url");// 对每个请求的URL处理，这个方法会自动追加jsessionid参数

            response.sendRedirect("/test_springmvc/test.jsp");
        } else {
            response.getWriter().print("登录失败～！");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
