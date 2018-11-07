package dao;

import model.Book2;

import java.util.List;

public interface Book2Dao {
    boolean add (Book2 book2);
    boolean delete(Book2 book2);
    boolean modify (Book2 book2);
    List findAll(int pageNow, int pageSize);
    int findAllSize();
    List findSome(String title, int pageNow, int pageSize);
    int findSomeSize(String title);
    Book2 findById(String id);
    int findByAuthor(String author);
}
