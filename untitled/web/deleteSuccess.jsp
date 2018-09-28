<%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/9/28
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>deleteSuccess</title>
</head>
<body>
    <h1>
        <s:property value="#session['user'].username"/>,删除书籍成功。
    </h1>
<h3>
    删除了书籍：<br>
    书名：<s:property value="book.title"/><br>
    价格：<s:property value="book.price"/><br>
</h3>
<a href="main.jsp">返回主页</a>
<a href="findAllBook.action">继续浏览</a>
</body>
</html>
