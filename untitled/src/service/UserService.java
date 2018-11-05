package service;

import model.User;

public interface UserService {
    public User validateUser(String username, String password);
    public User registerUser(User user);
}
