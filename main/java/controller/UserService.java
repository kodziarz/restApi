package controller;
import model.User;

import java.util.HashMap;

public interface UserService {
    void addUser(User user);
    HashMap<String, User> getAllUsers();
    User getUser(String id);
    User editUser(User user);
    void deleteUser(String id);
    Boolean userExists(String id);
    String generateUserId();
}
