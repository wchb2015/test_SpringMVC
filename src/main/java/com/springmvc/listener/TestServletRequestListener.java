package com.springmvc.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created by wangchongbei on 16-1-13.
 */
public class TestServletRequestListener implements ServletRequestListener {
    private static final Log LOG = LogFactory.getLog(TestServletRequestListener.class);

    public void requestInitialized(ServletRequestEvent sre) {

        LOG.info("###################__TestServletRequestListener_requestInitialized()! 创建Request对象！");
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        LOG.info("###################__TestServletRequestListener_requestDestroyed()!　销毁Request对象！");
    }
}
