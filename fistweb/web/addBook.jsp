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
</head>
<body>
<form action = "AddBook_Servlet" method="post">
    <table>
        <caption>添加书籍</caption>
        <tr>
            <td>书名：</td>
            <td>
                <input type="text" name="title" size="20">
            </td>
        </tr>
        <tr>
            <td>单价：</td>
            <td>
                <input type="text" name="price" size="20">
            </td>
        </tr>
    </table>
    <input type="submit" value="提交"/>
    <input type="reset" value="重置"/>
</form>
</body>
</html>
