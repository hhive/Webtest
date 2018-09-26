package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.BookDao;
import model.Book;
import java.util.Iterator;
import java.util.List;


public class FindBookAction extends ActionSupport {

    List<Book> bookList;
    private String title;

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


    public String execute() {
        bookList = new BookDao().find(title);
        if (0 != bookList.size()) {
            return "success";
        } else {
            return "error";
        }
    }

//    	public void validate() {
//		if (null == title || title.equals("")) {
//			addFieldError("title", "书名不能为空！");
//		}
//	}

}
