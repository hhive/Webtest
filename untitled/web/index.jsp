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
<s:form action="login" method="post">
  姓名：<input type="text" name="user.username" size="20" /><br>
  <s:fielderror>
    <s:param>username</s:param>
  </s:fielderror>
  密码：<input type="password" name="user.password" size="20" /><br>
  <s:fielderror>
    <s:param>password</s:param>
  </s:fielderror>
  <input type="submit" value="登录" />
  <input type="reset" value="重置" />
</s:form>
<a href="register.jsp">注册</a>
</body>
</html>