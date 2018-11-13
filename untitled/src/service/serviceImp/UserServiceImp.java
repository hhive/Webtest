package service.serviceImp;

import dao.UserDao;
import model.User;
import service.UserService;

import java.util.List;

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
    public List findAll(int pageNow, int pageSize) {
        return userDao.findAll(pageNow, pageSize);
    }
    public int findAllSize() {
        return userDao.findAllSize();
    }
    public List findSome(String title, int pageNow, int pageSize) {
        return userDao.findSome(title, pageNow, pageSize);
    }
    public int findSomeSize(String title) {
        return userDao.findSomeSize(title);
    }

    public boolean modify(User user) {
        return userDao.modify(user);
    }

    public boolean delete(User user) {
        return userDao.delete(user);
    }
}
