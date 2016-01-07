<%--
  Created by IntelliJ IDEA.
  User: wangchongbei
  Date: 15-12-24
  Time: 下午4:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
$END$
<a href="TestServletC">TestServletC</a>

<br>

<form method="post" id="test" action="TestServletC">

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
