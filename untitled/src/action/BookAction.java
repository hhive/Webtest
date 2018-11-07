package action;

import com.opensymphony.xwork2.ActionContext;
import dao.Book2Dao;
import model.Author;
import model.Book2;
import service.BookService;
import tool.Pager;

import java.io.*;
import java.util.List;

public class BookAction {

    private Author author;
    List bookList;
    List allBookList;
    private String title;
    private File upload;
    private String uploadFileName;
    private int flag = 1;
    private Pager pager;
    private int pageNow = 1;
    private int pageSize = 8;

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    private BookService bookService;
    public Book2 getBook2() {
        return book2;
    }

    public void setBook2(Book2 book2) {
        this.book2 = book2;
    }

    private Book2 book2;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public int isFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public List getAllBookList() {
        return allBookList;
    }

    public void setAllBookList(List allBookList) {
        this.allBookList = allBookList;
    }

    public List getBookList() {
        return bookList;
    }

    public void setBookList(List bookList) {
        this.bookList = bookList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void validate() {
        System.out.println("BookManageAction validate()");
    }

    public String addBook() {
        System.out.println("book2.getTitle()" + book2.getTitle());
        saveFile();
        book2.setAuthor(author);
        if (bookService.add(book2)) {
            flag = 1;
            return "success";
        } else {
            flag = 2;
            book2 = null;
            return "error";
        }
    }
    public String modifyBook() {
        System.out.println("modify1");
        if (upload != null) {
            File file = new File("E:\\study\\Java EE\\test9\\untitled\\src\\resource\\bookIntro\\"
                    + bookService.findById(book2.getBookId()).getIntro());
            file.delete();
            saveFile();
        }
        book2.setAuthor(author);
        if (bookService.modify(book2)) {
            flag = 3;
            return "success";
        } else {
            return "error";
        }
    }

    public String findBook() {
        int totalSize = bookService.findSomeSize(title);
        System.out.println(totalSize);
        Pager page = new Pager(getPageNow(), totalSize);
        bookList = bookService.findSome(title, pageNow, pageSize);
        ActionContext.getContext().put("page", page);
        if (0 != bookList.size()) {
            return "success";
        } else {
            flag = 5;
            return "error";
        }
    }

    public String findAllToPage() {
        int totalSize = bookService.findAllSize();
        Pager page = new Pager(getPageNow(), totalSize);
        if (getPageNow() <= page.getTotalPage() && getPageNow() > 0) {
            //System.out.println(getPageNow());
            allBookList = bookService.findAll(pageNow, pageSize);
            ActionContext.getContext().put("page", page);
        }else {
            allBookList = bookService.findAll(1, pageSize);
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
        book2.setAuthor(author);
        if (bookService.delete(book2, author.getName())) {
            return "success";
        } else {
            return "error";
        }
    }

    public String showIntro() {
        try {
            System.out.println(book2.getBookId() + book2.getIntro());
            StringBuilder buffer = new StringBuilder();
            BufferedReader bf = new BufferedReader(new FileReader
                    ("E:\\study\\Java EE\\test9\\untitled\\src\\resource\\bookIntro\\" + book2.getBookId() + book2.getIntro()));

            String s = null;
            while ((s = bf.readLine()) != null) {//使用readLine方法，一次读一行
                buffer.append(s.trim() + "\r\n");
            }
            book2.setIntro(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    public void saveFile() {
        try {
            if (getUpload() != null) {
                System.out.println(getUploadFileName());
                FileInputStream fis = new FileInputStream(getUpload());
                OutputStream os = new FileOutputStream(
                        "E:\\study\\Java EE\\try4\\untitled\\src\\resource\\bookIntro\\" + book2.getBookId() + getUploadFileName());
                byte[] buffer = new byte[fis.available()];
                int count = 0;
                while ((count = fis.read(buffer)) > 0) {
                    os.write(buffer, 0, count);
                }
                book2.setIntro(getUploadFileName());
                System.out.println("intro:" + book2.getIntro());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
