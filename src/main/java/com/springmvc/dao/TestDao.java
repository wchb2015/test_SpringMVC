package com.springmvc.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by wangchongbei on 16-1-22.
 */
public class TestDao {
    private Log log = LogFactory.getLog(this.getClass());

    public void save() {
        log.info("_______TestDao.save()!!!");
    }
}
