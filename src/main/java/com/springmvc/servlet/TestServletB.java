package com.springmvc.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangchongbei on 16-1-7.
 */

public class TestServletB extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        Integer count = (Integer) context.getAttribute("count");

        if (count == null) {
            count = 1;
        } else {
            count++;
        }

        context.setAttribute("count", count);
        System.out.println("_____________count:" + count);

        /*
         二选一
         */
        response.getWriter();
//        response.getOutputStream();
        response.setCharacterEncoding("utf-8");

        /**
         * 不仅调用response.setCharaceterEncoding(“utf-8”);还会设置content-type响应头,客户端浏览器会使用content-type头来解读响应数据.
         */
        response.setContentType("text/html;charset=utf-8");
    }
}
