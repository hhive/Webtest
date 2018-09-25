<%@ page pageEncoding="utf-8" import="model.User"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
  User user = (User)session.getAttribute("user");
  if (null != user) {
    request.getRequestDispatcher("/main.jsp").forward(request,response);
  }
%>
<html>
<html>
<head><title>登录</title></head>
<body>
<form action="login" method="post">
  工号：<input type="text" name="username" size="20" /><br>
  密码：<input type="password" name="password" size="20" /><br>
  <input type="submit" value="登录" />
  <input type="reset" value="重置" />
</form>
</body>
</html>