import com.fasterxml.uuid.Generators;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.UserServiceImpl;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.post;

import model.User;

public class App {

    private static UserServiceImpl userServiceImpl = new UserServiceImpl();

    public static void main(String[] args) {
        get("/api/users", (req, res) -> handleGetUsers(req, res));
        get("/api/users/:id", (req, res) -> handleGetUser(req, res));
        post("/api/users", (req, res) -> handleAddUser(req, res));

    }


    public static String handleGetUsers(Request req, Response res) {

        Type listType = new TypeToken<HashMap<String, User>>(){}.getType();
        Gson gson = new Gson();
        return gson.toJson(userServiceImpl.getAllUsers(), listType);

    }

    public static String handleGetUser(Request req, Response res) {

        String id = req.params("id");
        Gson gson = new Gson();
        return gson.toJson(userServiceImpl.getUser(id), User.class);

    }

    public static String handleAddUser(Request req, Response res) {

        Gson gson = new Gson();
        System.out.println("dostałem: " + req.body());
        User user = gson.fromJson(req.body(), User.class);
        user.setId(userServiceImpl.generateUserId());
        System.out.println("sparsowany obiekt: " + user.toString());

        try {
            userServiceImpl.addUser(user);
            return "{\"status\":\"ok\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"status\":\"not ok\"}";
        }
    }

    public static String handleEditUser(Request req, Response res){

        Gson gson = new Gson();
        System.out.println("dostałem: " + req.body());
        User user = gson.fromJson(req.body(), User.class);

        if(userServiceImpl.userExist(user.getId())){
            userServiceImpl.editUser(user);
            return "{\"status\":\"ok\"}";
        } else {
            return "{\"status\":\"not ok\"}";
        }
    }
}
