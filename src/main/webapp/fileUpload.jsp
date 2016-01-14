<%--
  Created by IntelliJ IDEA.
  User: wangchongbei
  Date: 16-1-14
  Time: 下午4:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="fileUploadForm" action="${pageContext.request.contextPath }/FileUploadServlet" method="post"
      enctype="multipart/form-data">
    用户名：<input type="text" name="username"/><br/>
    文件1：<input type="file" name="file1"/><br/>
    文件2：<input type="file" name="file2"/><br/>
    <input type="submit" value="提交"/>
</form>

</body>
</html>
