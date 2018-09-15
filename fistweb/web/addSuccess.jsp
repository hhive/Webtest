<%@ page import="org.easybooks.test.model.vo.Book" %>
<%@ page import="org.easybooks.test.model.vo.User" %><%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/9/15
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addSuccess</title>

</head>
<body>
<h1>
    <%
        User user = (User)session.getAttribute("user");
        out.print(user.getName() + ",添加成功！");
    %>
</h1>
<hr>
<h3>
    <%
        Book book = (Book)session.getAttribute("book");
        out.print("书名：" + book.getTitle() + "<br>" + "价格：" + book.getPrice());
    %>
</h3>
<hr>
<h1>
    <a href="main.jsp">返回主页</a>
</h1>
</body>
</html>
