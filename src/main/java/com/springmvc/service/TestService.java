package com.springmvc.service;

import com.springmvc.dao.TestDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestService {
    private Log log = LogFactory.getLog(this.getClass());

    public void save() {
        log.info("741852_______TestService.save()!!!");
        TestDao dao = new TestDao();
        dao.save();
    }
}
