<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/11/12
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addUser</title>
</head>
<body>
<s:form action="addUser" method="post">
    姓名：<input type="text" name="user.username" size="20" /><br>
    <s:fielderror>
        <s:param>username</s:param>
    </s:fielderror>
    密码：<input type="password" name="user.password" size="20" /><br>
    <s:fielderror>
        <s:param>password</s:param>
    </s:fielderror>
    角色：<s:select name="user.role" list="#{'管理员':'管理员','读者':'读者'}" label="角色" headerKey="" headerValue="请选择"></s:select>
    <input type="submit" value="添加" />
    <input type="reset" value="重置" />
</s:form>
<a href="../main.jsp">返回主页</a>
</body>
</html>
