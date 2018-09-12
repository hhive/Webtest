<%--
  Created by IntelliJ IDEA.
  User: JAX
  Date: 2018/9/12
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addCourse</title>
</head>
<body>
<form action="addCourseServlet" method="post">
    <table>
        <caption>课程添加</caption>
        <tr>
            <td>
                课名：
            </td>
            <td>
                <input type="text" name="courseName"/>
            </td>
        </tr>
        <tr>
            <td>
                学分：
            </td>
            <td>
                <input type="text" name="credit"/>
            </td>
        </tr>
        <tr>
            <td>
                学时：
            </td>
            <td>
                <input type="text" name="period"/>
            </td>
        </tr>
        <tr>
            <td>
                考核：
            </td>
            <td>
                <input type="text" name="assessment"/>
            </td>
        </tr>
        <tr>
            <td>
                学期：
            </td>
            <td>
                <input type="text" name="term"/>
            </td>
        </tr>
        <tr>
            <td>
                简介：
            </td>
            <td>
                <input type="text" name="brief"/>
            </td>
        </tr>
    </table>
    <input type="submit" value="添加">
    <input type="reset" name="重置">
</form>
</body>
</html>
