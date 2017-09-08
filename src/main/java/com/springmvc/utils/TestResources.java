package com.springmvc.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestResources {
    private static Logger logger = LoggerFactory.getLogger(TestResources.class);

    private Map<String, String> propertiesMap = null;

    @org.junit.Test
    public void test() {
        try {
            propertiesMap = new HashMap<String, String>();
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream("/email.properties"));
            Enumeration enumeration = properties.propertyNames();
            while (enumeration.hasMoreElements()) {
                Object object = enumeration.nextElement();
                propertiesMap.put(object.toString(), properties.getProperty(object.toString()));
            }
            logger.info("mail.properties:" + propertiesMap.size());
            logger.info("mail.properties:" + propertiesMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGet() {
//  path 不以"/"开头时默认是从此类所在的包下取资源,以"/"开头则是从ClassPath根下获取.其只是通过path构造一个绝对路径,最终还是由ClassLoader获取资源.
        getClass().getResourceAsStream("/log4j.properties");
    }

}
