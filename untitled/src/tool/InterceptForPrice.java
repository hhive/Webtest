package tool;

import action.BookManageAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class InterceptForPrice extends AbstractInterceptor {
    public String intercept(ActionInvocation arg0)throws Exception {
        BookManageAction bookManageAction = (BookManageAction)arg0.getAction();
        if(bookManageAction.getBook().getPrice() < 10) {
            bookManageAction.setMessage("价格必须大于10");
            System.out.println(bookManageAction.getMessage());
        return Action.INPUT;
    }
        return arg0.invoke();
    }
}
