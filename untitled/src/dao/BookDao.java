package dao;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;
import jdbc.SqlSrvDBConn;
import model.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookDao {
    private SqlSrvDBConn sqlSrvDBConn;

    public BookDao() {
        sqlSrvDBConn = new SqlSrvDBConn();
    }

    public boolean add(Book book) {
        String sql = "insert into book2 (bookId,title,author,price,intro) values ('" + book.getBookId() + "','" + book.getTitle() + "','" + book.getAuthor() + "','" + book.getPrice() + "','" + book.getIntro() + "')";
        int rows = sqlSrvDBConn.executeUpdate(sql);
        sqlSrvDBConn.closeStmt();
        if (rows > 0)
            return true;
        else
            return false;
    }
    public boolean modify(Book book) {
        System.out.println("modify2");
        String sql = "update book2 set title = '" + book.getTitle()
                + "',author = '" + book.getAuthor() + "',price = '" + book.getPrice() + "' where bookId = '" + book.getBookId() + "'";
        int rows = sqlSrvDBConn.executeUpdate(sql);
        System.out.println(sql);
        sqlSrvDBConn.closeStmt();
        if (rows > 0) {
            return true;
        } else
            return false;
    }
    public int findCount(String title) {
        int size = 0;
        String sql = "select count(*) from book2 where title like '%"
                + title + "%' or author like '%" + title + "%' or price like '%" + title + "%'";
        ResultSet rs = sqlSrvDBConn.executeQuery(sql);
        try {
            if (rs != null && rs.next()){
                size = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return size;
    }

    public List<Book> find(String title, int PageNow, int PageSize) {
        Book book;
        ArrayList<Book> bookList = new ArrayList<>();
        String sql = "select * from book2 where title like '%"
                + title + "%' or author like '%" + title + "%' or price like '%" + title + "%' limit "
                + (PageNow - 1) * PageSize + "," + PageSize + "";
        ResultSet rs = sqlSrvDBConn.executeQuery(sql);
        try {
            while (rs != null && rs.next()) {
                book = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                bookList.add(book);
                System.out.println("find");
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
        String sql = "select * from book2";
        ResultSet rs = sqlSrvDBConn.executeQuery(sql);
        try {
            while (rs != null && rs.next()) {
                book = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
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
        String sql = "select * from book2 limit " + (PageNow - 1) * PageSize + "," + PageSize + "";
        ResultSet rs = sqlSrvDBConn.executeQuery(sql);
        try {
            while (rs != null && rs.next()) {
                book = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                allBookList.add(book);
            }
            if (rs != null) {
                rs.close();
            }
//            Iterator iterator = allBookList.iterator();
//            while (iterator.hasNext()) {
//                Book book1 = (Book)iterator.next();
//                System.out.println(book1.getTitle());
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlSrvDBConn.closeStmt();
        return allBookList;
    }

    public boolean delete(String bookId) {
        String sql = "delete from book2 where bookId = '"
                + bookId + "'" ;
        int row = sqlSrvDBConn.executeUpdate(sql);
        if (row > 0) {
            return true;
        } else {
            return false;
        }
    }
    public String showIntro(String bookId) {
        String intro = null;
        String sql = "select intro from book2 where bookId = '"
                + bookId + "'" ;
        ResultSet rs = sqlSrvDBConn.executeQuery(sql);
        try {
            while (rs != null && rs.next()) {
                intro = rs.getString(1);
                System.out.println(intro);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlSrvDBConn.closeStmt();
        return intro;
    }
}
