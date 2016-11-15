package com.springmvc.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 如果是POST请求,当执行目标Servlet时,Servlet中调用request.getParameter()方法时,就会根据request.setCharacterEncoding()设置的编码来转码！
 * 这说明在过滤器中调用request.setCharacterEncoding()方法会影响在目标Servlet中的request.getParameter()方法的行为！
 * <p/>
 * 但是如果是GET请求,我们又如何能影响request.getParameter()方法的行为呢？这是不好做到的！
 * 我们不可能先调用request.getParameter()方法获取参数,然后手动转码后,再施加在到request中！
 * 因为request只有getParameter(),而没有setParameter()方法.
 * <p/>
 * 处理GET请求参数编码问题,需要在Filter中放行时,把request对象给“调包”了,也就是让目标Servlet使用我们“调包”之后的request对象.
 * 这说明我们需要保证“调包”之后的request对象中所有方法都要与“调包”之前一样可以使用,并且getParameter()方法还要有能力返回转码之后的参数.
 */

public class EncodingFilter implements Filter {
    String charset = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        charset = filterConfig.getInitParameter("charset");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("EncodingFilter_doFilter");

        if (StringUtils.isEmpty(charset)) {
            charset = "UTF-8";
        }

       /*  request.setCharacterEncoding(charset);//[处理POST请求编码]
        response.setContentType("text/html;charset=" + charset);//[处理响应编码]
        chain.doFilter(request, response);*/

        response.setCharacterEncoding(charset);
        response.setContentType("text/html;charset=" + charset);
        EncodingRequest res = new EncodingRequest((HttpServletRequest) request, charset);//[创建EncodingRequest对象，使用request为底层对象]
        chain.doFilter(res, response);//[放行！这时用户获取到的request就是EncodingRequest对象了！]
    }

    public void destroy() {

    }
}
