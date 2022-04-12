package controller;

import static spark.Spark.*;
import model.User;
import spark.Request;
import spark.Response;

import java.util.HashMap;

public class UserServiceImpl implements UserService {

    private HashMap<String, User> usersHahMap = new HashMap<>();

    @Override
    public void addUser(User user) {
        usersHahMap.put("1", user);
    }

    @Override
    public HashMap<String, User> getAllUsers() {
        return usersHahMap;
    }

    @Override
    public User getUser(String id) {
        return usersHahMap.get(id);
    }

    @Override
    public User editUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public Boolean userExist(String id) {
        return null;
    }
}