<%@ page import="com.springmvc.model.User" %><%--
  Created by IntelliJ IDEA.
  User: wangchongbei
  Date: 16-1-8
  Time: 下午4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    pageContext.setAttribute("u1", new User("Tom", "111", 22));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

${pageScope.u1.username}<br>
${pageScope.u1.passwd}<br>
${pageScope.u1.age}<br>

EL:${param.aaa}<br>
EL:${param.bbb}<br>
EL:header.Host:${header.Host}<br>
<c:out value="${aaaa}" default="defaultContent"/> <br>
1+2+3 = ${1+2+3} <br>
1+2+3 = <c:out value="6"/> <br>
1+2+3 = <c:out value="${1+2+3}"/> <br>
</body>
</html>
