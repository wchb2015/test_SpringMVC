package com.springmvc.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class IPFilter implements Filter {
    private Log LOG = LogFactory.getLog(this.getClass());
    private ServletContext context;

    public void init(FilterConfig filterConfig) throws ServletException {
        context = filterConfig.getServletContext();//保存ServletContext
        Map<String, Integer> ipCountMap = Collections.synchronizedMap(new LinkedHashMap<String, Integer>());
        context.setAttribute("ipCountMap", ipCountMap);//创建一个Map，保存到ServletContext中
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOG.info("741852   IPFilter_doFilter()_start!");
        HttpServletRequest req = (HttpServletRequest) request;
        String ip = getRemoteIpAddress(req);//获取请求方的ip

        Map<String, Long> ipCountMap = (Map<String, Long>) context.getAttribute("ipCountMap");//在context中获取Map

        if (ipCountMap == null) {
            ipCountMap = new HashMap<String, Long>();
        }

        Long count = ipCountMap.get(ip);//在Map中获取当前ip的访问次数

        if (count == null) {
            count = 1L;//如果这个ip在map中不存在，那么设置访问次数为1
        } else {
            count += 1;//否则在原有次数上加1
        }

        ipCountMap.put(ip, count);//把ip和次数设置到map中

        context.setAttribute("ipCountMap", ipCountMap);//把map存放到context中

        LOG.info(req.getRequestURL() + "?" + req.getQueryString() + " ------------------ start");
        chain.doFilter(request, response);
        LOG.info(req.getRequestURL() + "?" + req.getQueryString() + " ------------------ end");

        LOG.info("741852   ipCountMap:" + ipCountMap.toString());
        LOG.info("741852   IPFilter_doFilter()_end!");
    }

    public void destroy() {

    }

    public static String getRemoteIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
