<%@ page import="model.User1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page pageEncoding="utf-8" %>
<html>
<head>
	<title>主页</title>
</head>
<body>
	<h1>
		图书管理系统
	</h1>
	<p>
		<s:set name="user" value="#session['user']"/>
		当前用户: <s:property value="#user.username"/>[<a href="logout.action"
													onclick="if(!confirm('确定注销吗'))return false;else return true;">注销</a>]
		<%--<s:property value="#session.user.username"/><br>--%>
		<%--<s:property value="#session['user'].username"/><br>--%>
		<%--<s:property value="user.username"/>--%>
	</p>


<hr>
<ol type="1" start="1">
	<li><a href="bookManage/addBook.jsp">添加图书</a></li>
	<li><a href="searchBook/findBook.jsp">查询图书</a></li>
	<li><a href="findAllToPage.action">浏览图书</a></li>
</ol>
    <%--<s:form action="logout" method="post">--%>
        <%--<input type="submit" value="注销">--%>

<s:debug/>
</body>
</html>
