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

    public List<Book> findAll() {
        Book book;
        ArrayList<Book> allBookList = new ArrayList<>();
        String sql = "select * from book";
        ResultSet rs = sqlSrvDBConn.executeQuery(sql);
        try {
            while (rs != null && rs.next()) {
                book = new Book(rs.getString(2), rs.getInt(3));
                allBookList.add(book);
//                System.out.println(book.getTitle() + "," + book.getPrice());
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlSrvDBConn.closeStmt();
        return allBookList;
    }

    public List<Book> findAllTOPage(int PageNow, int PageSize) {
        Book book;
        ArrayList<Book> allBookList = new ArrayList<>();
        String sql = "select * from book limit " + PageNow * PageSize + "," + PageSize + "";
        ResultSet rs = sqlSrvDBConn.executeQuery(sql);
        try {
            while (rs != null && rs.next()) {
                book = new Book(rs.getString(2), rs.getInt(3));
                allBookList.add(book);
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlSrvDBConn.closeStmt();
        return allBookList;
    }

    public boolean delete(String title, int price) {
        String sql = "delete from book where title = '"
                + title + "' and price = '" + price + "'" ;
        int row = sqlSrvDBConn.executeUpdate(sql);
        if (row > 0) {
            return true;
        } else {
            return false;
        }
    }
}
