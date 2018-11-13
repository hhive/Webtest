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
<s:form action = "modifyBook" method="post" enctype="multipart/form-data">
    <table>
    <tr>
        <td>书号：</td>
        <td>
            <%--<c:set name="book.bookId" >v${param.bookId}</c:set>--%>
        <input type="text" name="book2.bookId" value="<s:property value="book2.bookId"/>" size="20" readonly="readonly">
        </td>
    </tr>
    <tr>
        <td>书名：</td>
        <td>
        <input type="text" name="book2.title" value=" <s:property value="book2.title"/>" size="20">
        </td>
    </tr>
        <tr>
        <td>单价：</td>
        <td>
        <input type="text" name="book2.price" value="<s:property value="book2.price"/>" size="20">
            <s:if test="hasActionMessages()">
                你好
            </s:if>
            <s:actionmessage/>
        </td>
    </tr>
        <tr>
            <td>简介：</td>
            <td>
                <s:file name="upload" label="上传的文件"/>
            </td>
        </tr>
        <tr>
            <td>作者：</td>
            <td>
                <input type="text" name="author.name" value="<s:property value="author.name"/>" size="20" >
            </td>
        </tr>
        <tr>
            <td>作者电话：</td>
            <td>
                <input type="text" name="author.tel" value="<s:property value="author.tel"/>">
            </td>
        </tr>
        <tr>
            <td>作者邮箱：</td>
            <td>
                <input type="text" name="author.email" value="<s:property value="author.email"/>">
            </td>
        </tr>
    </table>
    <input type="submit" value="修改"/>
    <s:if test="flag == 3">
        修改成功。
    </s:if>
</s:form>
<a href="findBook.action">继续查询</a>
<a href="../main.jsp">返回主页</a>
</body>
</html>
