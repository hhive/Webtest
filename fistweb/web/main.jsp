<%@ page import="org.easybooks.test.model.vo.User" %>
<%@ page language="java" pageEncoding="gb2312"%>
<html>
<head>
	<title>留言板信息</title>
</head>
<body>
	<h1>
		<%
			User user = (User)session.getAttribute("user");
			out.print(user.getName() + "，您好！欢迎登录图书管理系统。");
		%>
	</h1>
<hr>
<ol type="1" start="1">
	<li><a href="addBook.jsp">添加图书</a></li>
	<li><a href="findBook.jsp">查询图书</a></li>
</ol>
</body>
</html>
