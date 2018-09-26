package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.BookDao;
import model.Book;

public class AddBookAction extends ActionSupport {

    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String execute() {
        System.out.println(book.getTitle());
        if (new BookDao().add(book)) {
            return "success";
        } else {
            return "error";
        }
    }



}
