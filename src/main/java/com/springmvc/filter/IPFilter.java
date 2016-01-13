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

/**
 * Created by wangchongbei on 16-1-13.
 */
public class IPFilter implements Filter {
    private static final Log LOG = LogFactory.getLog(IPFilter.class);
    private ServletContext context;

    public void init(FilterConfig filterConfig) throws ServletException {
        context = filterConfig.getServletContext();//保存ServletContext
        Map<String, Integer> ipCountMap = Collections.synchronizedMap(new LinkedHashMap<String, Integer>());
        context.setAttribute("ipCountMap", ipCountMap);//创建一个Map，保存到ServletContext中
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOG.info("###################__IPFilter_doFilter()_start!");
        HttpServletRequest req = (HttpServletRequest) request;
        String ip = req.getRemoteAddr();//获取请求方的ip

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
        chain.doFilter(request, response);
        LOG.info("###################__ipCountMap:" + ipCountMap.toString());
        LOG.info("###################__IPFilter_doFilter()_end!");
    }

    public void destroy() {

    }
}
