package com.springmvc.action;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class ExportController {

    @RequestMapping(value = "/excel", method = RequestMethod.GET)
    @ResponseBody
    public Object exportDailyOperationExcel(HttpServletResponse response) {
        String csvFileName = "test1.csv";

        StringBuffer buf = new StringBuffer();
        buf.append("id,Name").append(System.getProperties().getProperty("line.separator")).append("1,Prashant Ghimire 中文");

        buildResponse(response, csvFileName);
        buildContent(response, buf.toString());

        return null;
    }

    private void buildResponse(HttpServletResponse response, String fileName) {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
    }

    private void buildContent(HttpServletResponse response, String content) {
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(content.getBytes("UTF-8"));
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
