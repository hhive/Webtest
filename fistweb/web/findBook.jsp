<%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/9/15
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>findBook</title>
</head>
<body>
    <form action="FindBook_Servlet" method="post">
            书名：<input type="text" name = "title"><br><br>
            <input type="submit" value="查询">
            <input type="reset" value="重置">
    </form>
</body>
</html>
