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
    <table align="center">
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
                <input type="radio" name="assessment" value="考试" checked="checked"/><label>考试</label>
                <input type="radio" name="assessment" value="考查"/><label>考查</label>
            </td>
        </tr>
        <tr>
            <td>
                学期：
            </td>
            <td>
                <select name="term">
                    <option value="1">一</option>
                    <option value="2">二</option>
                    <option value="3">三</option>
                    <option value="4">四</option>
                    <option value="5">五</option>
                    <option value="6">六</option>
                    <option value="7">七</option>
                    <option value="7">八</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                简介：
            </td>
            <td>
                <textarea name="brief" cols="22" rows="3"></textarea>
            </td>
        </tr>
    </table>
    <p align="center">
        <input type="submit" value="添加" onclick="return check(this.form)">
        <input type="reset" name="重置">
    </p>

</form>
<script type="text/javascript">
    function check(form) {
        var errString = "";
        var courseName = form.courseName.value.trim();
        var credit = form.credit.value.trim();
        var period = form.period.value.trim();
        if (courseName == "" || null == courseName) {
            errString = errString + "课程名不能为空";
        } else if (!/^\w{1.20}&/.test(courseName)){
            errString = errString + "书名必须是数字或字母且在4到25为之间"
        }
        if (credit == "" || null == credit) {
            errString = errString + "\n学分不能为空";
        } else if (credit < 0 || !/^\d+(\.\d+)?$/.test(credit)) {
            errString = errString + "\n学分必须为整数或小数且大于0"
        }
        if (period == "" || null == period) {
            errString = errString + "\n学时不能为空"
        } else if (period < 0 || !/^\d{1，2}$/.test(period)) {
            errString = errString + "\n学时必须为整数且大于0"
        }
        if (period / 16 != credit) {
            errString = errString+ "\n请输入正确的学分和时长"
        }
        if (errString == "") {
            return true;
        } else {
            alert(errString)
            return false;
        }
    }
</script>
</body>
</html>
