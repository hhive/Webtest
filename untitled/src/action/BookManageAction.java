package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.BookDao;
import model.Book;
import org.apache.struts2.ServletActionContext;
import tool.Pager;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BookManageAction extends ActionSupport {

    private Book book;
    List<Book> bookList;
    List<Book> allBookList;
    private String title;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    private String uploadFileName;

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    private File upload;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean flag;

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
        try {
            if (getUpload() != null) {
                System.out.println(getUploadFileName());

                //BufferedInputStream bis = new BufferedInputStream(new FileInputStream(getUpload()));
                String path = ServletActionContext.getServletContext().getRealPath("/bookIntro" + "\\" + uploadFileName);
               // BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));

//                StringBuffer buffer1 = new StringBuffer();
//                BufferedReader bf= new BufferedReader(new FileReader(getUpload()));
//                String s = null;
//                while((s = bf.readLine())!=null){//使用readLine方法，一次读一行
//                    buffer1.append(s.trim());
//                }

                FileInputStream fis = new FileInputStream(getUpload());
                OutputStream os = new FileOutputStream(
                        "E:\\study\\Java EE\\try4\\untitled\\src\\resource\\bookIntro\\" + book.getBookId() + getUploadFileName());
                byte[] buffer = new byte[fis.available()];
                int count = 0;
                while ((count = fis.read(buffer)) > 0) {
                    os.write(buffer, 0, count);
                }
//                for (byte x : buffer) {
//                    System.out.println(x);
//                }


                book.setIntro(getUploadFileName());
                System.out.println("intro:" + book.getIntro());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (new BookDao().add(book)) {
//            String mes =  "成功添加书籍：" + book.getTitle() + "," + book.getAuthor() + "," + book.getPrice();
//            ActionContext.getContext().getSession().put("mes",mes);
            flag = false;
            return "success";
        } else {
            flag = true;
            book = null;
            return "error";
        }
    }
    public String modifyBook() {
        System.out.println("modify1");
        try {
            System.out.println(new BookDao().findById(book.getBookId()).getIntro());
            File file = new File("E:\\study\\Java EE\\try4\\untitled\\src\\resource\\bookIntro\\"
                    + new BookDao().findById(book.getBookId()).getIntro());
            file.delete();
            if (getUpload() != null) {
                System.out.println(getUploadFileName());
                FileInputStream fis = new FileInputStream(getUpload());
                OutputStream os = new FileOutputStream(
                        "E:\\study\\Java EE\\try4\\untitled\\src\\resource\\bookIntro\\" + book.getBookId() + getUploadFileName());
                byte[] buffer = new byte[fis.available()];
                int count = 0;
                while ((count = fis.read(buffer)) > 0) {
                    os.write(buffer, 0, count);
                }
                book.setIntro(getUploadFileName());
                System.out.println("intro:" + book.getIntro());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public String showIntro() {
        String theBookId = book.getBookId();
        book = new BookDao().showIntro(theBookId);
        try {
            StringBuilder buffer = new StringBuilder();
            BufferedReader bf = new BufferedReader(new FileReader
                    ("E:\\study\\Java EE\\try4\\untitled\\src\\resource\\bookIntro\\" + book.getBookId() + book.getIntro()));
            String s = null;
            while ((s = bf.readLine()) != null) {//使用readLine方法，一次读一行
                buffer.append(s.trim() + "\r\n");
            }
            book.setIntro(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
