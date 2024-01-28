package repository.user;

import base.repository.BaseRepositoryImpel;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl extends BaseRepositoryImpel<Integer, User> implements UserRepository {

    public UserRepositoryImpl(Connection connection){
        super(connection);
    }
    @Override
    public String getTableName() {
        return "users";
    }

    @Override
    public String getColumnName() {
        return "firstname,lastname,username,password";
    }

    @Override
    public String getCountOfQuestionMarks() {
        return "(?,?,?,?)";
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, User entity, Boolean isCountOnly) throws SQLException {
        preparedStatement.setString(1, entity.getFirstName());
        preparedStatement.setString(2, entity.getLastName());
        preparedStatement.setString(3, entity.getUsername());
        preparedStatement.setString(4, entity.getPassword());
    }

    @Override
    public User mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setFirstName(resultSet.getString("firstname"));
        user.setLastName(resultSet.getString("lastname"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;

        //second way???

//        User user1 = new User(
//                resultSet.getInt("id"),
//                resultSet.getString("firstname"),
//                resultSet.getString("lastname"),
//                resultSet.getString("username"),
//                resultSet.getString("password")
//        )

    }

    @Override
    public String getUpdateQueryParams() {
        return "firstname = ? , lastname = ? , username = ? , password = ?";
    }



}
