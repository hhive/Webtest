package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import model.Book;
import model.User;

import java.util.Map;

public class LoginAction extends ActionSupport {

	private User user;
	private String username;
	private String password;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String login() {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		User user = (User)session.get("user");
		if (user == null) {
			user = new UserDao().validate(username, password);
			if (user != null) {
				session.put("user", user);
//				ActionContext.getContext().put("user", user);
				return "success";
			} else {
				return "error";
			}
		} else {
			return "success";
		}
	}

    public void validate() {
        System.out.println("validate()");
    }

    //validate() will verify all methods, but validateXXX() will just verify XXX().
	public void validateLogin() {
		System.out.println("validateLogin()");
		if (null == username || username.equals("")) {
			addFieldError("username", "姓名不能为空!");
		}
		if (null == password || password.equals("")) {
			addFieldError("password", "密码不能为空!");
		}
	}

	public String logout() {
		System.out.println("1");
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		session.clear();
		return INPUT;
	}
}
