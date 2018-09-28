package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.BookDao;
import model.Book;
import tool.Pager;

import java.util.List;
import java.util.Map;

public class BookManageAction extends ActionSupport {

    private Book book;
    List<Book> bookList;
    List<Book> allBookList;
    private String title;

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    private Pager pager;
    private int pageNow = 1;
    private int pageSize = 8;

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public List<Book> getAllBookList() {
        return allBookList;
    }

    public void setAllBookList(List<Book> allBookList) {
        this.allBookList = allBookList;
    }

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

    public String findAllBook() {
        allBookList = new BookDao().findAll();
        if (0 != allBookList.size()) {
            return "success";
        } else {
            return "error";
        }
    }

    public String findAllToPage() {
        allBookList = new BookDao().findAllTOPage(pageNow, pageSize);
        int totalSize = new BookDao().findAll().size();
        Pager page = new Pager(getPageNow(), totalSize);
        ActionContext.getContext().put("page", page);
        if (0 != allBookList.size()) {
                return "success";
            } else {
                return "error";
            }
    }

    public String deleteBook() {
        String theTitle = book.getTitle();
        int thePrice = book.getPrice();

        System.out.println(theTitle);
        System.out.println("thePrice:" + thePrice);

        if (new BookDao().delete(theTitle, thePrice)) {
            return "success";
        } else {
            return "error";
        }
    }
}
