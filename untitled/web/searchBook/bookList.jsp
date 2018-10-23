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
        <td>书号</td>
        <td>书名</td>
        <td>作者</td>
        <td>价格</td>
        <td>操作</td>
    </tr>
    <s:iterator value="allBookList" id="bL">
        <tr>
            <td>
                <s:property value="#bL.bookId"/>
            </td>
            <td>
                <s:property value="#bL.title"/>
            </td>
            <td>
                <s:property value="#bL.author"/>
            </td>
            <td>
                <s:property value="#bL.price"/>
            </td>
            <td>
                <a href="showIntro.action?book.bookId=<s:property value="#bL.bookId"/>">简介</a>
                <%--<a href="modifyBook.action?bookId=<s:property value="#bL.bookId"/>&title=<s:property value="#bL.title"/>&author=<s:property value="#bL.author"/>&price=<s:property value="#bL.price"/>">修改</a>--%>
                    <a href="modifyBook.action?book.bookId=<s:property value="#bL.bookId"/>&book.title=<s:property value="#bL.title"/>&book.author=<s:property value="#bL.author"/>&book.price=<s:property value="#bL.price"/>">修改</a>
                    <%--<a href="modifyBook.action?book.bookId=<s:property value="#bL.bookId"/>">修改</a>--%>
                <a href="delete.action?book2.bookId=<s:property value="#bL.bookId"/>&book2.title=<s:property value="#bL.title"/>&book2.author=<s:property value="#bL.author"/>&book2.price=<s:property value="#bL.price"/>"
                   onclick="if(!confirm('确定删除这本书吗？'))return false;else return true;">删除</a>
            </td>
        </tr>
    </s:iterator>
</table><br>
<s:div>
    <s:set name="page" value="#page"/>
    <s:if test="#page.hasFirst">
        <s:a href="findAllToPage.action?pageNow=1">首页</s:a>
    </s:if>
    <s:if test="#page.hasPre">
        <a href="findAllToPage.action?pageNow=<s:property value="#page.pageNow-1"/>">上一页</a>
    </s:if>

    <s:property value="#page.pageNow"/>/<s:property value="#page.totalPage"/>

    <s:if test="#page.hasNext">
        <a href="findAllToPage.action?pageNow=<s:property value="#page.pageNow+1"/>">下一页</a>
    </s:if>
    <s:if test="#page.hasLast">
        <a href="findAllToPage.action?pageNow=<s:property value="#page.totalPage"/>">尾页</a>
    </s:if><br>
    <form action="findAllToPage.action" method="post" onsubmit="return validate()">
    输入页数：<input type="text" name="pageNow" size="2" oninput = "value=value.replace(/[^\d]/g,'')">
    <input type="submit" value="跳转">
    </form>
</s:div><br><br>
<a href="../main.jsp">返回主页</a>
<s:debug/>
</body>
<script type="text/javascript">
    function validate() {
        var page = document.getElementsByName("pageNow")[0].value;
        if (page < 1 || page > <s:property value="#page.totalPage"/>) {
            alert("输入的页数不能小于1或大于总页数");
            window.document.location.href="findAllToPage.action?pageNow=<s:property value="#page.pageNow"/>";
            return false;
        }
        return true;
    }
</script>
</html>
