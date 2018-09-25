package dao;

import jdbc.SqlSrvDBConn;
import model.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private SqlSrvDBConn sqlSrvDBConn;

    public BookDao() {
        sqlSrvDBConn = new SqlSrvDBConn();
    }

    public boolean add(Book book) {
        String sql = "insert into book (title,price) values ('" + book.getTitle() + "','" + book.getPrice() + "')";
        int rows = sqlSrvDBConn.executeUpdate(sql);
        sqlSrvDBConn.closeStmt();
        if (rows > 0)
            return true;
        else
            return false;
    }

    //    public Book find(String title) {
//        Book book = null;
//        String sql = "select * from book where title = '" + title + "'";
//        ResultSet rs = sqlSrvDBConn.executeQuery(sql);
//        try {
//            while (rs != null && rs.next()) {
//                book = new Book(title,rs.getInt(3));
//                System.out.println(book.getTitle() + "," + book.getPrice());
//            }
//
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        sqlSrvDBConn.closeStmt();
//        return book;
//    }
    public List<Book> find(String title) {
        Book book = null;
        ArrayList<Book> bookList = new ArrayList<>();
        String sql = "select * from book where title = '" + title + "'";
        ResultSet rs = sqlSrvDBConn.executeQuery(sql);
        try {
            while (rs != null && rs.next()) {
                book = new Book(title, rs.getInt(3));
                bookList.add(book);
                System.out.println(book.getTitle() + "," + book.getPrice());
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlSrvDBConn.closeStmt();
        return bookList;
    }
}
