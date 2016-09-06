package com.springmvc.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class FileUploadServlet extends HttpServlet {
    private Log LOG = LogFactory.getLog(this.getClass());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* InputStream in = request.getInputStream();
        String s = IOUtils.toString(in);//[使用apache的commons的io组件，把流中的数据读取出来转换成字符串]
        System.out.println(s);
*/
//        FileUtils.openInputStream(new File(""));



        /*
         * 上传三步
		 * 1. 得到工厂
		 * 2. 通过工厂创建解析器
		 * 3. 解析request,得到FileItem集合
		 * 4. 遍历FileItem集合，调用其API完成文件的保存
		 */
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);

        sfu.setFileSizeMax(10 * 1024 * 1024);//10M

        try {

            List<FileItem> fileItemList = sfu.parseRequest(request);

//          一个FileItem对象对应一个表单项(表单字段),一个表单中存在文件字段和普通字段,可以使用FileItem类的isFormField()方法来判断表单字段是否为普通字段,如果不是普通字段,那么就是文件字段了.
            for (FileItem fileItem : fileItemList) {

                if (fileItem.isFormField()) {

                    System.out.println("_________FormField:" + fileItem.getFieldName() + "=" + fileItem.getString("UTF-8"));

                } else {

                    String name = fileItem.getName();//获取上传文件的名称
                    // 如果上传的文件名称为空,即没有指定上传文件
                    if (StringUtils.isEmpty(name)) {
                        continue;
                    }

                    String savePath = this.getServletContext().getRealPath("/WEB-INF/uploads");  // 获取真实路径，对应${项目目录}/uploads,当然,这个目录必须存在

                    File file = new File(savePath, name);  // 通过uploads目录和文件名称来创建File对象

                    // TODO: 16-1-22
                    //fileItem.write(file); // 把上传文件保存到指定位置

                    response.getWriter().print("上传文件名：" + name + "<br/>"); // 打印上传文件的名称

                    response.getWriter().print("上传文件大小：" + fileItem.getSize() + "<br/>"); // 打印上传文件的大小

                    response.getWriter().print("上传文件类型：" + fileItem.getContentType() + "<br/>");// 打印上传文件的类型
                }

            }

        } catch (Exception e) {

            // 判断抛出的异常的类型是否为FileUploadBase.FileSizeLimitExceededException
            // 如果是,说明上传文件时超出了限制.
            if (e instanceof FileUploadBase.FileSizeLimitExceededException) {
                // 在request中保存错误信息
                request.setAttribute("msg", "上传失败！上传的文件超出了10M!");
                // 转发到index.jsp页面中！在index.jsp页面中需要使用${msg}来显示错误信息
                request.getRequestDispatcher("/error.jsp").forward(request, response);
                return;
            }

            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
