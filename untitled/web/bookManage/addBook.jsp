<%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/9/10
  Time: 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>ADD</title>
</head>
<body>
<%--<s:fielderror name="book.title"/>--%>
<%--<s:fielderror name="book.price"/>--%>
<s:fielderror>
    <s:param>book2.title</s:param>
</s:fielderror>
<s:fielderror>
    <s:param>book2.price</s:param>
</s:fielderror>
<s:form action = "addBook" method="post" enctype="multipart/form-data">
    <table>
        <caption>添加书籍</caption>
        <tr>
            <td>书号：</td>
            <td>
                <input type="text" name="book2.bookId" size="20">
            </td>
        </tr>
        <tr>
            <td>书名：</td>
            <td>
                <input type="text" name="book2.title" size="20">
            </td>
        </tr>
        <%--<tr>--%>
            <%--<td>作者：</td>--%>
            <%--<td>--%>
                <%--<input type="text" name="book2.author" size="20">--%>
            <%--</td>--%>
        <%--</tr>--%>
        <tr>
            <td>单价：</td>
            <td>
                <input type="text" name="book2.price" size="20"><br>
                <s:if test="message != null">
                    书籍价格必须大于10元
                </s:if>
               <%--<s:property value="message"/>--%>
                <%--<s:actionmessage/>--%>
            </td>
        </tr>
        <tr>
            <td>简介：</td>
            <td>
                <s:file name="upload" label="上传的文件"/>
            </td>
        </tr>
        <tr>
            <td>作者姓名：</td>
            <td>
                <input type="text" name="author.name">
            </td>
        </tr>
        <tr>
        <td>作者电话：</td>
        <td>
            <input type="text" name="author.tel">
        </td>
        </tr>
        <tr>
        <td>作者邮箱：</td>
        <td>
            <input type="text" name="author.email">
        </td>
        </tr>
    </table>
    <input type="submit" value="提交"/>
    <input type="reset" value="重置"/><br>
    <%--<s:property value="book.title"/><br>--%>
    <s:if test="book2.title != null&flag == 1">
        成功添加书籍：<br>
      <s:property value="book2.title"/>，<s:property value="book2.author.name"/>,<s:property value="book2.price"/>
    </s:if>
    <s:elseif test="flag == 2">
        添加失败。
    </s:elseif>
</s:form>
<a href="../main.jsp">返回主页</a>
</body>
</html>
