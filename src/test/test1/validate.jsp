<%@ page language="java" pageEncoding="gb2312" import="java.sql.*"%>
<jsp:useBean id="SqlSrvDB" scope="page" class="SqlSrvDBConn" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=gb2312">
    </head>
    <body>
        <%
            request.setCharacterEncoding("gb2312");				//设置请求编码
            String usr=request.getParameter("username");		//获取提交的用户名
            System.out.println(usr);
            String pwd=request.getParameter("password");		//获取提交的密码
            boolean validated=false;							//验证成功标识
            //查询userTable表中的记录
            String sql="select * from user";
            ResultSet rs=SqlSrvDB.executeQuery(sql);			//取得结果集
            while(rs.next())
            {
                if((rs.getString("username").trim().compareTo(usr)==0)&&(rs.getString("password").compareTo(pwd)==0))
                {
                    validated=true;								//标识为true表示验证成功通过
                }
            }
            rs.close();
            SqlSrvDB.closeStmt();
            SqlSrvDB.closeConn();
            if(validated)
            {
                //验证成功跳转到main.jsp
        %>
                <jsp:forward page="main.jsp"/>
        <%
            }
            else
            {
                //验证失败跳转到error.jsp
        %>
                <jsp:forward page="../test2/error.jsp"/>
        <%
            }
        %>
    </body>
</html>
