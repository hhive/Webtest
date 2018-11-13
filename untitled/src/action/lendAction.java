package action;

import com.opensymphony.xwork2.ActionContext;
import model.Lend;
import model.User;
import service.LendService;
import tool.Pager;

import java.util.Calendar;
import java.sql.Date;
import java.util.Map;

public class lendAction extends BookAction {
    private int pageSize = 8;
    boolean borrowSuccess;
    private String message;
    private int flag;
    public LendService getLendService() {
        return lendService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLendService(LendService lendService) {
        this.lendService = lendService;
    }

    LendService lendService;

    public Lend getLend() {
        return lend;
    }

    public void setLend(Lend lend) {
        this.lend = lend;
    }

    Lend lend;

    public int getFlag() {
        return flag;
    }

    @Override
    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String showBookToLend() {
        if(findAllToPage() == "success") {
            return "success";
        } else {
            return "error";
        }
    }
    public String findBookToLend() {
        if (findBook() == "success") {
            return "success";
        } else {
            return "error";
        }
    }

    public String borrowBook() {
        System.out.println(message);
        Map session = ActionContext.getContext().getSession();
        User user = (User)session.get("user");
        lend.setName(user.getUsername());
        Date date = new java.sql.Date(new java.util.Date().getTime());
        lend.setLtime(date);
        if (lendService.borrow(lend)) {
            flag = 1;
            return "success";
        } else {
            borrowSuccess = false;
            return "error";
        }
    }

    public String reBackBook() {
        System.out.println("reBackBook" + lend.getIsbn());
        Map session = ActionContext.getContext().getSession();
        User user = (User)session.get("user");
        lend.setName(user.getUsername());
        if (lendService.reBack(lend)) {
            flag = 2;
            return "success";
        } else {
            return "error";
        }
    }

    public String showBorrowBook() {
        int totalSize = lendService.findBorrowBookSize(getPageNow(),pageSize);
        System.out.println(totalSize);
        Map session = ActionContext.getContext().getSession();
        User user = (User)session.get("user");
        Pager page = new Pager(getPageNow(), totalSize);
        bookList = lendService.findBorrowBook(user.getUsername(), getPageNow(), pageSize);
        ActionContext.getContext().put("page", page);
        if (0 != bookList.size()) {
            return "success";
        } else {
            return "error";
        }
    }
}
