<%@ page language="java" pageEncoding="gb2312" import="java.sql.*"%>
<jsp:useBean id="SqlSrvDB" scope="page" class="org.easybooks.test.jdbc.SqlSrvDBConn" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=gb2312">
    </head>
    <body>
        <%
            request.setCharacterEncoding("gb2312");				//�����������
            String usr=request.getParameter("username");		//��ȡ�ύ���û���
            System.out.println(usr);
            String pwd=request.getParameter("password");		//��ȡ�ύ������
            boolean validated=false;							//��֤�ɹ���ʶ
            //��ѯuserTable���еļ�¼
            String sql="select * from user";
            ResultSet rs=SqlSrvDB.executeQuery(sql);			//ȡ�ý����
            while(rs.next())
            {
                if((rs.getString("username").trim().compareTo(usr)==0)&&(rs.getString("password").compareTo(pwd)==0))
                {
                    validated=true;								//��ʶΪtrue��ʾ��֤�ɹ�ͨ��
                }
            }
            rs.close();
            SqlSrvDB.closeStmt();
            SqlSrvDB.closeConn();
            if(validated)
            {
                //��֤�ɹ���ת��main.jsp
        %>
                <jsp:forward page="main.jsp"/>
        <%
            }
            else
            {
                //��֤ʧ����ת��error.jsp
        %>
                <jsp:forward page="error.jsp"/>
        <%
            }
        %>
    </body>
</html>
