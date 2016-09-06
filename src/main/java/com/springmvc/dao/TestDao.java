package com.springmvc.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestDao {
    private Log log = LogFactory.getLog(this.getClass());

    public void save() {
        log.info("_______TestDao.save()!!!");
    }
}
