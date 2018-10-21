package tool;

import action.BookManageAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class InterceptForPrice extends ActionSupport implements Interceptor {
    public String intercept(ActionInvocation arg0)throws Exception {
        BookManageAction bookManageAction = (BookManageAction)arg0.getAction();
        if(bookManageAction.getBook().getPrice() < 10) {
            bookManageAction.addActionMessage("价格必须大于10");
                return Action.INPUT;
        }
        return arg0.invoke();
    }
    public void init(){

    }
    public void destroy() {

    }
}
