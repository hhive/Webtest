package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.User;
import service.UserService;
import tool.Pager;

import java.util.List;
import java.util.Map;

public class LoginAction extends ActionSupport {
    ActionContext context;
	private User user;
	private List userList;
	private int pageNow = 1;
	private int pageSize = 8;
	private String title;

	public User getTmpUser() {
		return tmpUser;
	}

	public void setTmpUser(User tmpUser) {
		this.tmpUser = tmpUser;
	}

	private User tmpUser;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List getUserList() {
		return userList;
	}

	public void setUserList(List userList) {
		this.userList = userList;
	}

	public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    protected UserService userService;
	public String execute() throws Exception{
		String usr=user.getUsername();			//获取提交的用户名
		String pwd=user.getPassword();			//获取提交的密码
		boolean validated=false;				//验证成功标识
		//ApplicationContext sp_context=new FileSystemXmlApplicationContext("file:E:/study/Java EE/webtrst/ssh1/untitled/src/applicationContext.xml");//改
		context=ActionContext.getContext();
		Map session=context.getSession();		//获得会话对象，用来保存当前登录用户的信息
		User user1=null;
		//先获得 UserTable 对象，如果是第一次访问该页，用户对象肯定为空，但如果是第二次甚至是第三次，就直接登录主页而无须再次重复验证该用户的信息
		user1=(User)session.get("user");
		//如果用户是第一次进入，会话中尚未存储 user1 持久化对象，故为 null
		if(user1==null){
			user1 = userService.validateUser(usr,pwd);
			if(user1!=null){
				session.put("user", user1);		//把 user1 对象存储在会话中
				user = user1;
				System.out.println(user.getRole());
				validated=true;					//标识为 true 表示验证成功通过
			}
		}
		else{
			validated=true;									//该用户在之前已登录过并成功验证，故标识为 true 表示无须再验了
		}
		if(validated)
		{
			//验证成功返回字符串"success"
			return "success";
		}
		else{
			//验证失败返回字符串"error"
			return "error";
		}

	}
	public String register() {
	    User u = new User(user.getUsername(),user.getPassword(),user.getRole());
	    User user1 = null;
	    user1 = userService.registerUser(u);
	    if(user1 != null) {
			context=ActionContext.getContext();
	        Map session = context.getSession();
	        session.clear();
	        session.put("user",user1);
	        return SUCCESS;
        }
        return ERROR;
    }
	public String addUser() {
		User u = new User(user.getUsername(),user.getPassword(),user.getRole());//没有这行就无法插入，为什么？
		if(userService.registerUser(u) != null) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String logout() {
		System.out.println("1");
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		session.clear();
		return INPUT;
	}

	public String findSomeUser() {
		int totalSize = userService.findSomeSize(title);
		System.out.println(totalSize);
		Pager page = new Pager(getPageNow(), totalSize);
		userList = userService.findSome(title, pageNow, pageSize);
		ActionContext.getContext().put("page", page);
		if (0 != userList.size()) {
			return "success";
		} else {
//			flag = 5;
			return "error";
		}
	}

	public String findAllUser() {
		int totalSize = userService.findAllSize();
		Pager page = new Pager(getPageNow(), totalSize);
			//System.out.println(getPageNow());
		userList = userService.findAll(pageNow, pageSize);
		ActionContext.getContext().put("page", page);
		if (0 != userList.size()) {
			return "success";
		} else {
			return "error";
		}
	}

	public String modifyUser() {
		if (userService.modify(tmpUser)) {
			return "success";
		} else {
			return "error";
		}
	}

	public String deleteUser() {
		if (userService.delete(tmpUser)) {
			return "success";
		} else {
			return "error";
		}
	}

	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user=user;
	}

}
