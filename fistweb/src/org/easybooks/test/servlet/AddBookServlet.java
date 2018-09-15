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

public class AddBookServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        doGet(request,response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        int price = Integer.parseInt(request.getParameter("price"));
        Book book = new Book();
        HttpSession session = request.getSession();
        SqlSrvDBConn srvDBConn = new SqlSrvDBConn();
        String sql = "insert into book (title,price) values ('" + title + "','" + price + "')";
        int rows = srvDBConn.executeUpdate(sql);
        if (rows != 0) {
            book.setTitle(title);
            book.setPrice(price);
            session.setAttribute("book",book);
            RequestDispatcher dispatcher = request.getRequestDispatcher("addSuccess.jsp");
            dispatcher.forward(request,response);
        } else {
            System.out.println("添加失败");
        }
        srvDBConn.closeStmt();
    }
}
