package main;

import Utility.ApplicationContext;
import model.User;
import service.user.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = ApplicationContext.getUserServiceImpl();

        User user = new User("milad","baran","MILAD","1234");
        userService.save(user);
    }
}
