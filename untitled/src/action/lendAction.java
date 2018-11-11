package action;

public class lendAction extends BookAction {

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
}
