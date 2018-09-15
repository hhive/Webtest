package org.easybooks.test.servlet;

import org.easybooks.test.jdbc.SqlSrvDBConn;
import org.easybooks.test.model.vo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        SqlSrvDBConn srvDBConn = new SqlSrvDBConn();
        HttpSession session = request.getSession();
        User user = null;
        boolean validated = false;
        user = (User)session.getAttribute("user");
        if(null == user) {
            String sql = "select *  from user";
            ResultSet rs = srvDBConn.executeQuery(sql);
            try {
                while (rs.next()) {
                    if ((rs.getString("username").trim().compareTo(name) == 0)
                            && (rs.getString("password").trim().compareTo(password) == 0)) {
                        user = new User();
                        user.setId(rs.getInt(1));
                        user.setName(rs.getString(2));
                        user.setPassword(rs.getString(3));
                        session.setAttribute("user",user);
                        validated = true;
                    }
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            srvDBConn.closeStmt();
        } else {
            validated = true;
        } if (validated) {
            RequestDispatcher disPatcher =request.getRequestDispatcher("main.jsp");
            disPatcher .forward(request, response);
        } else {
            RequestDispatcher disPatcher = request.getRequestDispatcher("error.jsp");
            disPatcher.forward(request,response);
        }
    }
}
