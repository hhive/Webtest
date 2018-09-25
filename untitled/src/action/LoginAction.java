package action;

import com.opensymphony.xwork2.ActionContext;
import dao.UserDao;
import model.Book;
import model.User;

import java.util.Map;

public class LoginAction {

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private User user;
	private String username;
	private String password;

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

	public String execute() {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		User user = (User)session.get("user");
		if (user == null) {
			user = new UserDao().validate(username, password);
			System.out.println(user.getUsername());
			if (user != null) {
				session.put("user", user);
				return "success";
			} else {
				return "error";
			}
		} else {
			return "success";
		}
	}
}
