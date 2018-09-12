<%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/9/10
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" %>
<jsp:useBean id="SqlSrvDB" scope="page" class="org.easybooks.test.jdbc.SqlSrvDBConn"/>
<html>
<head>
    <title>record</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    double price =  Double.parseDouble(request.getParameter("price"));
    double number = Double.parseDouble(request.getParameter("number"));
    String sql = "insert into add1 (name,price,number) values('" + name + "','" + price + "','" + number + "')";
    SqlSrvDB.executeUpdate(sql);
    SqlSrvDB.closeStmt();
    SqlSrvDB.closeConn();
    out.print("品名:" + name + "," + "金额：" + price * number);
    //out.print(session.getAttribute("name") + "," + session.getAttribute("price") + "," + session.getAttribute);
%>

</body>
</html>
