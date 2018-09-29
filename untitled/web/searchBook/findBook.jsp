<%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/9/15
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
</head>
<title>findBook</title>
<body>
<s:fielderror>
    <s:param>title</s:param>
</s:fielderror>
    <s:form action="findBook" method="post">
            书名：<input type="text" name = "title"/><br><br>
            <input type="submit" value="查询">
            <input type="reset" value="重置">
    </s:form>
<a href="main.jsp">返回主页</a>
</body>
</html>
