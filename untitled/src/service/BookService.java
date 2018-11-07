package service;

import model.Book2;

import java.util.List;

public interface BookService {
    public boolean add (Book2 book2);
    public boolean delete(Book2 book2, String author);
    public boolean modify (Book2 book2);
    public List findAll(int pageNow, int pageSize);
    public int findAllSize();
    public List findSome(String title, int pageNow, int pageSize);
    public int findSomeSize(String title);
    Book2 findById(String id);
}
