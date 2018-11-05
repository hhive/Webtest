<%@ page import="model.User" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page pageEncoding="utf-8" %>
<html>
<head>
	<title>主页</title>
</head>
<body>
	<h1>
		欢迎您！
	</h1>
	<p>
		<s:set name="user" value="#session['user']"/>
		当前用户: <s:property value="#user.username"/>
		<%--<s:property value="#session.user.username"/><br>--%>
		<%--<s:property value="#session['user'].username"/><br>--%>
		<%--<s:property value="user.username"/>--%>
	</p>

<s:debug/>
</body>
</html>
