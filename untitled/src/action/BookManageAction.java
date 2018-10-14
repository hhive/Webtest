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
            book = null;
            return "error";
        }
    }
    public String modifyBook() {
        System.out.println("modify1");
        if (new BookDao().modify(book)) {
            return "success";
        } else {
            return "error";
        }
    }
    public String findBook() {
        int totalSize = new BookDao().findCount(title);
        System.out.println(totalSize);
        Pager page = new Pager(getPageNow(), totalSize);
        bookList = new BookDao().find(title, pageNow, pageSize);
        ActionContext.getContext().put("page", page);
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
        int totalSize = new BookDao().findAll().size();
        Pager page = new Pager(getPageNow(), totalSize);
        if (getPageNow() <= page.getTotalPage() && getPageNow() > 0) {
            //System.out.println(getPageNow());
            allBookList = new BookDao().findAllTOPage(pageNow, pageSize);
            ActionContext.getContext().put("page", page);
        }else {
            allBookList = new BookDao().findAllTOPage(1, pageSize);
            page = new Pager(1, totalSize);
            ActionContext.getContext().put("page", page);
        }
        if (0 != allBookList.size()) {
                return "success";
            } else {
                return "error";
            }
    }

    public String deleteBook() {
        String theBookId = book.getBookId();

        if (new BookDao().delete(theBookId)) {
            return "success";
        } else {
            return "error";
        }
    }
}
