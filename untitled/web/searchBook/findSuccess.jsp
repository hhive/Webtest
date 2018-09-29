<%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/9/15
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>findSuccess</title>
</head>
<body>
<h1>
    <s:property value="#session['user'].username"/>，找到了书籍
</h1>
<hr>
<h3>
    <table border="1" width="100%">
        <tr>
            <td>书名</td>
            <td>价格</td>
        </tr>
        <s:iterator value="bookList" id="bL">
            <tr>
                <td>
                    <s:property value="#bL.title"/>
                </td>
                <td>
                    <s:property value="#bL.price"/>
                </td>
            </tr>
        </s:iterator>
    </table>

    <%--书名：<s:property value="book.title"/><br>--%>
    <%--价格：<s:property value="book.price"/>--%>
</h3>
<hr>
<h2>
    <a href="../main.jsp">返回主页</a>
</h2>
<s:debug/>
</body>
</html>
