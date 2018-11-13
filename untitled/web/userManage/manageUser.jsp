<%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/9/15
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <h1>
        图书浏览和查询
    </h1>
</head>
<title>findBook</title>
<body>
<s:fielderror>
    <s:param>title</s:param>
</s:fielderror>
<s:form action="findSomeUser" method="post">
    搜索条件：<input type="text" name = "title"/>
    <input type="submit" value="查询">
    <s:if test="#page.pageNow != null">
        <table border="1" cellpadding="10">
            <tr>
                <td>姓名</td>
                <td>密码</td>
                <td>角色</td>
                <td>操作</td>
            </tr>
            <s:iterator value="userList" id="tmpUser">
                <tr>
                    <td>
                        <s:property value="#tmpUser.username"/>
                    </td>
                    <td>
                        <s:property value="#tmpUser.password"/>
                    </td>
                    <td>
                        <s:property value="#tmpUser.role"/>
                    </td>
                    <td>
                        <a href="modifyUser.action?tmpUser.username=<s:property value="#tmpUser.username"/>&tmpUser.password=<s:property value="#tmpUser.password"/>
                        &tmpUser.role=<s:property value="#tmpUser.role"/>">修改</a>
                            <%--<a href="modifyBook.action?book.bookId=<s:property value="#bL.bookId"/>">修改</a>--%>
                        <a href="deleteUser.action?tmpUser.username=<s:property value="#tmpUser.username"/>&tmpUser.password=<s:property value="#tmpUser.password"/>"
                           onclick="if(!confirm('确定删除这本书吗？'))return false;else return true;">删除</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </s:if>
</s:form>
<s:div>
<s:set name="page" value="#page"/>
<s:if test="#page.hasFirst">
<a href="findBook.action?title=<s:property value="title"/>&pageNow=1">首页<a>
    </s:if>
    <s:if test="#page.hasPre">
    <a href="findBook.action?title=<s:property value="title"/>&pageNow=<s:property value="#page.pageNow-1"/>">上一页</a>
    </s:if>

        <%--<s:if test="#page.pageNow != null">--%>
        <%--<s:property value="#page.pageNow"/>/<s:property value="#page.totalPage"/>--%>
        <%--</s:if>--%>

    <s:if test="#page.hasNext">
    <a href="findBook.action?title=<s:property value="title"/>&pageNow=<s:property value="#page.pageNow+1"/>">下一页</a>
    </s:if>
    <s:if test="#page.hasLast">
    <a href="findBook.action?title=<s:property value="title"/>&pageNow=<s:property value="#page.totalPage"/>">尾页</a>
    </s:if><br>
    </s:div><br><br>
    <s:if test="flag == 5">
    没有相关数据
    </s:if><br>
    <a href="findAllToPage.action?pageNow=1">查询全部</a>
    <a href="../main.jsp">返回主页</a>
</body>
</html>
