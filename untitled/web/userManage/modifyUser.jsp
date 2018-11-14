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
<s:form action = "modifyUser" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>姓名：</td>
            <td>
                    <%--<c:set name="book.bookId" >v${param.bookId}</c:set>--%>
                <input type="text" name="tmpUser.username" value="<s:property value="tmpUser.username"/>" size="20" readonly="readonly">
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="text" name="tmpUser.password" value=" <s:property value="tmpUser.password"/>" size="20">
            </td>
        </tr>
        <tr>
            <td>角色：</td>
            <td>
                <input type="text" name="tmpUser.role" value="<s:property value="tmpUser.role"/>" size="20" readonly="readonly">

            </td>
        </tr>
    </table>
    <input type="submit" value="修改"/>
    <s:property value="message"/>
</s:form>
<a href="findAllUser.action ">继续查询</a>
<a href="../main.jsp">返回主页</a>
</body>
</html>
