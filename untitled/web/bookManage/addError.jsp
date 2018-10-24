<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%--Created by IntelliJ IDEA.--%>
<%--User1: JAX--%>
<%--Date: 2018/9/15--%>
<%--Time: 0:13--%>
<%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addSuccess</title>

</head>
<body>
<h1>
   <s:property value="#session['user'].username"/>
</h1>
<hr>
<h3>
   添加失败。
</h3>
<hr>
<h1>
    <a href="main.jsp">返回主页</a>
</h1>
</body>
</html>
