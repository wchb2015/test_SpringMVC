package com.springmvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("path");//[获取要下载的文件名称]
        String filepath = this.getServletContext().getRealPath("/WEB-INF/uploads/" + filename);
        // 因为文件都存放在WEB - INF / uploads目录下，所以需要获取文件的真实路径]
        File file = new File(filepath);
        if (!file.exists()) {
            response.getWriter().print("您要下载的文件不存在！");
            return;
        }

        response.setContentType("application/x-download");
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);

    }
}
