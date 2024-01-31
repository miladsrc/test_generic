package Utility;

import connection.util.connectionI;
import repository.user.UserRepository;
import repository.user.UserRepositoryImpl;
import service.user.UserService;
import service.user.UserServiceImpl;

import java.sql.Connection;

public class ApplicationContext {
    private static final Connection CONNECTION;
    private static final UserRepository USER_REPOSITORY;
    private static final UserService USER_SERVICE;

    static {
        CONNECTION = connectionI.getConnection();
        USER_REPOSITORY = new UserRepositoryImpl(CONNECTION);
        USER_SERVICE = new UserServiceImpl(USER_REPOSITORY);
    }

    public static UserService getUserServiceImpl(){
        return USER_SERVICE;
    }
}
