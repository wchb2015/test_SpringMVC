<%--
  Created by IntelliJ IDEA.
  User: wangchongbei
  Date: 16-1-11
  Time: 下午6:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js" type="text/javascript"></script>

    <style type="text/css">
        .red_7 {
            color: red
        }
    </style>
</head>
<body>

<button onclick="sayHello()">点我！</button>

<div>div的内容</div>
<div>Hello world!</div>
<div id="divTest" class="red_7">我是红色的</div>

<script type="text/javascript">
    function sayHello() {
        alert("hello!!!");
    }

//    $("div").html("Hello iMooc!");
    $("div").css("font-weight", "bold");

    var $className =$(".red_7").attr("class");
    $(".red_7").html($className);
</script>
</body>
</html>
