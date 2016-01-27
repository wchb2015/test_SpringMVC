<%--
  Created by IntelliJ IDEA.
  User: wangchongbei
  Date: 16-1-26
  Time: 下午5:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>All Users in System</h2>

<table border="1">
    <tr>
        <th>username</th>
        <th>passwd</th>
        <th>age</th>
        <th>createTime</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.passwd}</td>
            <td>${user.age}</td>
            <td>${user.createTime}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
