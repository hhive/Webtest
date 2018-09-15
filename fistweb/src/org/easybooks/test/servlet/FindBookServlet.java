package org.easybooks.test.servlet;

import org.easybooks.test.jdbc.SqlSrvDBConn;
import org.easybooks.test.model.vo.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindBookServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        doGet(request,response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        HttpSession session = request.getSession();
        SqlSrvDBConn srvDBConn = new SqlSrvDBConn();
        ArrayList<Book> bookList = new ArrayList<>();
        String sql = "select * from book where title = '" + title + "'";
        ResultSet rs = srvDBConn.executeQuery(sql);
        try {
            while (rs.next()) {
                Book book = new Book();
                book.setTitle(rs.getString(2));
                book.setPrice(rs.getInt(3));
                bookList.add(book);
                System.out.println(book.getTitle() + "," + book.getPrice());
            }
            session.setAttribute("bookList",bookList);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        srvDBConn.closeStmt();
        if (0 == bookList.size()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("findError.jsp");
            dispatcher.forward(request,response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("findSuccess.jsp");
            dispatcher.forward(request,response);
        }
    }
}
