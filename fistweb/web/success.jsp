<%@ page import="org.easybooks.test.model.vo.Course" %><%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/9/12
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body >
    <h1 align="center">添加课程信息成功!</h1>
    <p align="center">
        <%
            Course course = (Course)session.getAttribute("course");
            out.print(course.getCourseName() + ": "
                    + course.getCredit() + "," + course.getTerm() + "," + course.getAssessment());
        %>
    </p>
</body>
</html>
