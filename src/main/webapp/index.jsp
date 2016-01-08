<%
    String contextPath = request.getContextPath();//test_springmvc
    //http://localhost:8080/test_springmvc/
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
%>

<%--
page指令的pageEncoding和contentType:
pageEncoding指定当前JSP页面的编码！这个编码是给服务器看的,服务器需要知道当前JSP使用的编码,不然服务器无法正确把JSP编译成java文件.所以这个编码只需要与真实的页面编码一致即可！
contentType属性与response.setContentType()方法的作用相同！它会完成两项工作,一是设置响应字符流的编码,二是设置content-type响应头.
例如：<%@ contentType=”text/html;charset=utf-8”%>,它会使“真身”中出现response.setContentType(“text/html;charset=utf-8”).
无论是page指令的pageEncoding还是contentType,它们的默认值都是ISO-8859-1,我们知道ISO-8859-1是无法显示中文的,所以JSP页面中存在中文的话,一定要设置这两个属性。

pageEncoding和contentType的关系：
当pageEncoding和contentType只出现一个时,那么另一个的值与出现的值相同.如果两个都不出现,那么两个属性的值都是ISO-8859-1.所以通过我们至少设置它们两个其中一个！
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page errorPage="error.jsp" %>--%>

<html>
<head>
    <title>$Title$</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <%-- JSP注释   [这就相当于给客户端发送了响应头content-type，指定当前页面的编码为utf-8]--%>
    <!--HTML注释-->
</head>
<body>
$END$
<a href="TestServletC">TestServletC</a>

<br>

<form method="post" id="test" action="/test_springmvc/LoginServlet">

    <div align="center">
        <div>
            用户名：<input name="username" type="text"/>
        </div>

        <div>
            密码： <input name="passwd" type="password"/>
        </div>

        <div>
            <input type="submit" value="登录"/>
            <input type="reset" value="取消"/>
        </div>
    </div>


    <%--  <form id="ff" method="post">
          <div style="color:red;" class="message"><label></label></div>
          <div style="margin:20px;">
              <span for="username" class="login">用户名：</span>
              <input id="username" class="easyui-validatebox" type="text" name="user.userName" required="true"></input>
          </div>
          <div style="margin:20px;">
              <span for="passport" class="login">密　码：</span>
              <input id="password" class="easyui-validatebox" type="password" name="user.password"
                     required="true"></input>
          </div>
          <div style="margin:20px;">
              <span class="login"> </span>
              <input type="submit" value="登录"/>
              <input type="reset" value="取消"/>
          </div>
      </form>--%>

</form>
</body>
</html>
