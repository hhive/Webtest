<%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/9/10
  Time: 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD</title>
    <script type="text/javascript">
        function delete1(){
            var sql = "delete from add1 where name = " + name;
            alert(name);
            // SqlSrvDB.executeUpdate(sql);
            // SqlSrvDB.closeStmt();
            // SqlSrvDB.closeConn();
        }
    </script>
</head>
<body>
<form action = "record.jsp" method="post">
    <table>
        <caption>记账本</caption>
        <tr>
            <td>品名：</td>
            <td>
                <input type="text" name="name" size="20">
            </td>
        </tr>
        <tr>
            <td>单价：</td>
            <td>
                <input type="text" name="price" size="20">
            </td>
        </tr>
        <tr>
            <td>数量：</td>
            <td>
                <input type="text" name="number" size="20">
            </td>
        </tr>
    </table>
    <input type="submit" value="提交"/>
    <input type="reset" value="重置"/>
    <input type="button" value="删除" onclick="delete1()"/>
</form>
<%
    String name = request.getParameter("name");
    String price = request.getParameter("price");
    String number = request.getParameter("number");
    session.setAttribute("name",name);
    session.setAttribute("price",price);
    session.setAttribute("number",number);
%>
</body>
</html>
