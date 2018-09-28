<%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/9/27
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>浏览书籍</title>
    <style type="text/css">
        body{text-align: center;}
    </style>
</head>
<body>
<table border="1" cellpadding="10" align="center">
    <tr>
        <td>书名</td>
        <td>价格</td>
        <td>操作</td>
    </tr>
    <s:iterator value="allBookList" id="bL">
        <tr>
            <td>
                <s:property value="#bL.title"/>
            </td>
            <td>
                <s:property value="#bL.price"/>
            </td>
            <td>
                <a href="delete.action?book.title=<s:property value="#bL.title"/>&book.price=<s:property value="#bL.price"/> "
                   onclick="if(!confirm('确定删除这本书吗？'))return false;else return true;">删除</a>
                    <%--<a href="delete.action?book.title=<s:property value="#bL.title"/>"--%>
                       <%--onclick="if(!confirm('确定删除这本书吗？'))return false;else return true;">删除</a>--%>
            </td>
        </tr>
    </s:iterator>
</table><br>
<s:div>
    <s:set name="page" value="#page"/>
    <s:if test="#page.hasFirst">
        <s:a href="findAllToPage.action?pageNow=0">首页</s:a>
    </s:if>
    <s:if test="#page.hasPre">
        <a href="findAllToPage.action?pageNow=<s:property value="#page.pageNow-1"/>">上一页</a>
    </s:if>
    <s:if test="#page.hasNext">
        <a href="findAllToPage.action?pageNow=<s:property value="#page.pageNow+1"/>">下一页</a>
    </s:if>
    <s:if test="#page.hasLast">
        <a href="findAllToPage.action?pageNow=<s:property value="#page.totalPage"/>">尾页</a>
    </s:if>
</s:div><br><br>
<a href="main.jsp">返回主页</a>
<s:debug/>
</body>
</html>
