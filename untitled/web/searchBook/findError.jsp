<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="model.User1" %><%--
  Created by IntelliJ IDEA.
  User1: JAX
  Date: 2018/9/15
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>findError</title>
</head>
<body>
<h1>
<s:property value="session.user.username"/>,没有找到你需要的书籍！
</h1>
<hr>
<h2>
    <a href="../main.jsp">返回主页</a>
</h2>
</body>
</html>
