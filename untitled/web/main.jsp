<%@ page import="model.User" %>
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
	当前用户: <s:property value="#user.username"/> (<s:property value="#user.role"/>)  [<a href="logout.action"
																					   onclick="if(!confirm('确定注销吗'))return false;else return true;">注销</a>]
	<%--<s:property value="#session.user.username"/><br>--%>
	<%--<s:property value="#session['user'].username"/><br>--%>
</p>


<hr>
<s:if test="#session.user.role == '管理员'">
	<ol type="1" start="1">
		<li><a href="userManage/addUser.jsp?message=<s:property value=""/>">添加用户</a> </li>
		<li><a href="findAllUser.action?message=<s:property value=""/>">管理用户</a> </li>
		<li><a href="bookManage/addBook.jsp">添加图书</a></li>
		<li><a href="bookManage/findBook.jsp">查询图书</a></li>
		<li><a href="findAllToPage.action?pageNow=1">浏览图书</a></li>
	</ol>
</s:if>
<s:else>
	<ol type="1" start="1">
		<li><a href="showBorrowBook.action?message=<s:property value=""/>&flag=<s:property value="1"/> ">已借书籍</a></li>
		<li><a href="<s:url value="showBookToLend.action">
					<s:param name="message"/>
					<s:param name="flag" value="2"/>
				</s:url>">
			借阅书籍</a></li>
	</ol>
</s:else>
<%--<s:form action="logout" method="post">--%>
<%--<input type="submit" value="注销">--%>

<s:debug/>
</body>
</html>
