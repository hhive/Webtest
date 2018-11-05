package service.serviceImp;

import dao.UserDao;
import model.User;
import service.UserService;

public class UserServiceImp implements UserService {

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private UserDao userDao;

    public User validateUser(String username, String password) {
        return userDao.validate(username,password);
    }
    public User registerUser(User user) {
        userDao.saveUser(user);
        return validateUser(user.getUsername(),user.getPassword());
    }
}
