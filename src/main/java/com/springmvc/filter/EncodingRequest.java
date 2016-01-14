package com.springmvc.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/**
 * Created by wangchongbei on 16-1-14.
 */
public class EncodingRequest extends HttpServletRequestWrapper {

    private String charset;

    public EncodingRequest(HttpServletRequest request, String charset) {
        super(request);
        this.charset = charset;
    }

    public String getParameter(String name) {
        HttpServletRequest request = (HttpServletRequest) getRequest();
        String method = request.getMethod();
        if (method.equalsIgnoreCase("post")) {
            try {
                request.setCharacterEncoding(charset);
            } catch (UnsupportedEncodingException e) {
            }
        } else if (method.equalsIgnoreCase("get")) {
            String value = request.getParameter(name);
            try {
                value = new String(name.getBytes("ISO-8859-1"), charset);
            } catch (UnsupportedEncodingException e) {
            }
            return value;
        }
        return request.getParameter(name);
    }
}
