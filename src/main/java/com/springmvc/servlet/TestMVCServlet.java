package com.springmvc.servlet;

import com.springmvc.service.TestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestMVCServlet extends HttpServlet {
    private Log log = LogFactory.getLog(this.getClass());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("741852_______TestMVCServlet.doGet()!!!");
        TestService service = new TestService();
        service.save();
    }
}
