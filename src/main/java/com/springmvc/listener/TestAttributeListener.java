package com.springmvc.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class TestAttributeListener implements ServletContextAttributeListener, HttpSessionAttributeListener, ServletRequestAttributeListener {
    private static final Log LOG = LogFactory.getLog(TestAttributeListener.class);

    //ServletContextAttributeListener
    public void attributeAdded(ServletContextAttributeEvent event) {
        LOG.info("###################__ServletContextAttributeListener_attributeAdded()!");
    }

    public void attributeRemoved(ServletContextAttributeEvent event) {
        LOG.info("###################__ServletContextAttributeListener_attributeRemoved()!");
    }

    public void attributeReplaced(ServletContextAttributeEvent event) {
        LOG.info("###################__ServletContextAttributeListener_attributeReplaced()!");
    }

    //HttpSessionAttributeListener
    public void attributeAdded(HttpSessionBindingEvent event) {
        LOG.info("###################__HttpSessionAttributeListener_attributeAdded()!");
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        LOG.info("###################__HttpSessionAttributeListener_attributeRemoved()!");
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        LOG.info("###################__HttpSessionAttributeListener_attributeReplaced()!");
    }


    //ServletRequestAttributeListener
    public void attributeAdded(ServletRequestAttributeEvent srae) {

        LOG.info("###################__ServletRequestAttributeListener_attributeAdded()!Name:" + srae.getName() + "___Value:" + srae.getValue());
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        LOG.info("###################__ServletRequestAttributeListener_attributeRemoved()!Name:" + srae.getName() + "___Value:" + srae.getValue());
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        LOG.info("###################__ServletRequestAttributeListener_attributeReplaced()!Name:" + srae.getName() + "___Value:" + srae.getValue());
    }
}
