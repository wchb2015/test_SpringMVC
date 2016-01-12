package com.springmvc.servlet;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by wangchongbei on 16-1-12.
 */
public class BaseServlet extends HttpServlet {

    // 它会根据请求中的m，来决定调用本类的哪个方法
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=utf-8");

        // 例如：http://localhost:8080/demo1/xxx?m=add
        String methodName = req.getParameter("method");// 它是一个方法名称

        if (StringUtils.isEmpty(methodName)) {
            methodName = "execute";
        }

        Class c = this.getClass();

        try {
            // 通过方法名称获取方法的反射对象
            Method m = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 反射方法目标方法，也就是说，如果methodName为add，那么就调用add方法。
            String result = (String) m.invoke(this, req, res);

            // 通过返回值完成请求转发
            if (StringUtils.isNotEmpty(result)) {
                req.getRequestDispatcher(result).forward(req, res);
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

}
