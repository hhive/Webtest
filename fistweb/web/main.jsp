<%@ page import="org.easybooks.test.model.vo.User" %>
<%@ page language="java" pageEncoding="gb2312"%>
<html>
<head>
	<title>���԰���Ϣ</title>
</head>
<body>
	<h1>
		<%
			User user = (User)session.getAttribute("user");
			out.print(user.getName() + "�����ã���ӭ��¼ͼ�����ϵͳ��");
		%>
	</h1>
<hr>
<ol type="1" start="1">
	<li><a href="addBook.jsp">���ͼ��</a></li>
	<li><a href="findBook.jsp">��ѯͼ��</a></li>
</ol>
</body>
</html>
