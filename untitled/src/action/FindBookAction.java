package action;

import dao.BookDao;
import model.Book;
import java.util.Iterator;
import java.util.List;


public class FindBookAction {
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    List<Book> bookList;
//    private Book book;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }

    public String execute() {
//        ActionContext context = ActionContext.getContext();
//        Map<String, Object> session = context.getSession();
        bookList = new BookDao().find(title);
        //session.put("bookList",bookList);

//        Iterator iterator = bookList.iterator();
//        while (iterator.hasNext()) {
//            book = (Book)iterator.next();
//            System.out.println(book.getTitle() + "," + book.getPrice());
//        }

        if (0 != bookList.size()) {
            return "success";
        } else {
            return "error";
        }
    }


}
