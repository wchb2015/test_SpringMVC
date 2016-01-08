<%--
  Created by IntelliJ IDEA.
  User: wangchongbei
  Date: 16-1-8
  Time: 下午3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<%--[设置页面为错误页,在错误页中就可以使用exception隐藏对象了.
        注意：一旦转发到错误页，那么Tomcat会把状态码设置为500,而不在是200了.]--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>出错了～！</h1>

<%
    System.out.println(exception.getMessage());
    System.out.println("______" + exception.getStackTrace().toString());
%>


</body>
</html>
