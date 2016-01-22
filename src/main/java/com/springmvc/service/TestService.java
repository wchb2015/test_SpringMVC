package com.springmvc.service;

import com.springmvc.dao.TestDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by wangchongbei on 16-1-22.
 */
public class TestService {
    private Log log = LogFactory.getLog(this.getClass());

    public void save() {
        log.info("_______TestService.save()!!!");
        TestDao dao = new TestDao();
        dao.save();
    }
}
