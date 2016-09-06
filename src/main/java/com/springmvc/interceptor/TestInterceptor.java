package com.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInterceptor implements HandlerInterceptor {

    //返回值表示是否将当前的请求拦截下来,false请求将被终止,true请求继续执行.
    //o表示的是倍拦截的请求的目标对象
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("___$$$   TestInterceptor.preHandle()");
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("___$$$   TestInterceptor.postHandle()");

        if (httpServletRequest.getSession().getAttribute("user") == null) {
            //如果没有登录就终止请求,并发送到登录页面
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, httpServletResponse);
        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("___$$$   TestInterceptor.afterCompletion()");
    }

}
