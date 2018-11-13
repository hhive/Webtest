package dao;

import model.User;

import java.util.List;

public interface UserDao {
    public User validate(String username, String password);
    public void saveUser(User user);
    public List findAll(int pageNow, int pageSize);
    public int findAllSize();
    public List findSome(String title, int pageNow, int pageSize);
    public int findSomeSize(String title);
    public boolean modify(User user);
    public boolean delete(User user);
}
