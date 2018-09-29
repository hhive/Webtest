<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: JAX--%>
  <%--Date: 2018/9/15--%>
  <%--Time: 0:13--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<html>
<head>
    <title>addSuccess</title>

</head>
<body>
<h1>
<s:property value="#session['user'].username"/>，你成功添加了书籍
</h1>
<hr>
<h3>
成功添加书籍：<br>
    书名：<s:property value="book.title"/><br>
    价格：<s:property value="book.price"/>
</h3>
<hr>
<h1>
    <a href="../main.jsp">返回主页</a>
</h1>
</body>
</html>
