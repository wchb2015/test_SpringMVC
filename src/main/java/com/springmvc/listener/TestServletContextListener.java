package com.springmvc.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by wangchongbei on 16-1-13.
 */
public class TestServletContextListener implements ServletContextListener {
    private static final Log LOG = LogFactory.getLog(TestServletContextListener.class);

    public void contextInitialized(ServletContextEvent sce) {
        LOG.info("###################__TestServletContextListener_contextInitialized()!");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        LOG.info("###################__TestServletContextListener_contextDestroyed()!");
    }
}
