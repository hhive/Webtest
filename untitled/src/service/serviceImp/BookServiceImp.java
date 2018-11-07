package service.serviceImp;

import dao.Book2Dao;
import model.Book2;
import service.BookService;
import java.util.List;

public class BookServiceImp implements BookService {
    public Book2Dao getBook2Dao() {
        return book2Dao;
    }

    public void setBook2Dao(Book2Dao book2Dao) {
        this.book2Dao = book2Dao;
    }

    private Book2Dao book2Dao;
    public boolean add (Book2 book2) {
        return book2Dao.add(book2);
    }
    public boolean delete(Book2 book2,String author) {
        if (book2Dao.findByAuthor(author) > 1) {
            System.out.println(author);
            book2.setAuthor(null);
        }
        return book2Dao.delete(book2);
    }
    public boolean modify (Book2 book2) {
        return book2Dao.modify(book2);
    }
    public List findAll(int pageNow, int pageSize) {
        return book2Dao.findAll(pageNow,pageSize);
    }
    public int findAllSize() {
        return book2Dao.findAllSize();
    }
    public List findSome(String title, int pageNow, int pageSize) {
        return book2Dao.findSome(title, pageNow, pageSize);
    }
    public int findSomeSize(String title) {
        return book2Dao.findSomeSize(title);
    }

    public Book2 findById(String id) {
        return book2Dao.findById(id);
    }
}
