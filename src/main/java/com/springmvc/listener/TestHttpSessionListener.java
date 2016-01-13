package com.springmvc.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by wangchongbei on 16-1-13.
 */
public class TestHttpSessionListener implements HttpSessionListener {
    private static final Log LOG = LogFactory.getLog(TestHttpSessionListener.class);

    public void sessionCreated(HttpSessionEvent se) {
        LOG.info("###################__TestHttpSessionListener_sessionCreated()!  创建Session对象！");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        LOG.info("###################__TestHttpSessionListener_sessionDestroyed()!　销毁Session对象！");
    }
}
