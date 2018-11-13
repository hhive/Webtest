package service;

import model.User;

import java.util.List;

public interface UserService {
    public User validateUser(String username, String password);
    public User registerUser(User user);
    public List findAll(int pageNow, int pageSize);
    public int findAllSize();
    public List findSome(String title, int pageNow, int pageSize);
    public int findSomeSize(String title);
    public boolean modify(User user);
    public boolean delete(User user);
}
