package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.BookDao;
import model.Book;

import java.util.List;

public class BookManageAction extends ActionSupport {

    private Book book;
    List<Book> bookList;
    private String title;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String addBook() {
        System.out.println(book.getTitle());
        if (new BookDao().add(book)) {
            return "success";
        } else {
            return "error";
        }
    }
    public String findBook() {
        bookList = new BookDao().find(title);
        if (0 != bookList.size()) {
            return "success";
        } else {
            return "error";
        }
    }


}
