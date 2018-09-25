<%@ page import="model.User" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page pageEncoding="utf-8" %>
<html>
<head>
	<title>主页</title>
</head>
<body>
	<h1>
		<s:set name="user" value="#session['user']"/>
		<s:property value="#user.username"/>，欢迎登录图书管理系统<br>
		<%--<s:property value="#session.user.username"/><br>--%>
		<%--<s:property value="#session['user'].username"/><br>--%>
		<%--<s:property value="user.username"/>--%>
	</h1>
<hr>
<ol type="1" start="1">
	<li><a href="addBook.jsp">添加图书</a></li>
	<li><a href="findBook.jsp">查询图书</a></li>
</ol>
<s:debug/>
</body>
</html>
