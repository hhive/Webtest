<%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/9/10
  Time: 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>ADD</title>
</head>
<body>
<%--<s:fielderror name="book.title"/>--%>
<%--<s:fielderror name="book.price"/>--%>
<s:fielderror>
    <s:param>book.title</s:param>
</s:fielderror>
<s:fielderror>
    <s:param>book.price</s:param>
</s:fielderror>
<s:form action = "addBook" method="post" validate="true">
    <table>
        <caption>添加书籍</caption>
        <tr>
            <td>书名：</td>
            <td>
                <input type="text" name="book.title" size="20">
            </td>
        </tr>
        <tr>
            <td>单价：</td>
            <td>
                <input type="text" name="book.price" size="20">
            </td>
        </tr>
    </table>
    <input type="submit" value="提交"/>
    <input type="reset" value="重置"/>
</s:form>
</body>
</html>
