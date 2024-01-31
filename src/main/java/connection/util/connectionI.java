package connection.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionI {
    private static Connection connection = null;

    private connectionI() {
    }

    ;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/generic_user"
                        , "postgres"
                        , "9010231394");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
