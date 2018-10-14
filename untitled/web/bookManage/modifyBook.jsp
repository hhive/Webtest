<%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/10/14
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>ModifyBook</title>
    <h1>
        修改书籍
    </h1>
</head>
<body>
<s:form action = "modifyBook" method="post" validate="true">
    <table>
    <tr>
        <td>书号：</td>
        <td>
            <%--<c:set name="book.bookId" >v${param.bookId}</c:set>--%>
        <input type="text" name="book.bookId" value="${param.bookId}<s:property value="book.bookId"/>" size="20" readonly="readonly">
        </td>
    </tr>
    <tr>
        <td>书名：</td>
        <td>
        <input type="text" name="book.title" value="${param.title} <s:property value="book.title"/>" size="20">
        </td>
    </tr>
    <tr>
        <td>作者：</td>
        <td>
        <input type="text" name="book.author" value="${param.author}<s:property value="book.author"/>" size="20">
        </td>
    </tr>
        <tr>
        <td>单价：</td>
        <td>
        <input type="text" name="book.price" value="${param.price}<s:property value="book.price"/>" size="20">
        </td>
    </tr>
    </table>
    <input type="submit" value="修改"/>
    <s:if test="book.bookId != null">
        修改成功。
    </s:if>
</s:form>
<a href="findBook.action">继续查询</a>
<a href="../main.jsp">返回主页</a>
</body>
</html>
