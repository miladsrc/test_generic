package base.repository;

import base.model.BaseEntity;

import javax.swing.*;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseRepositoryImpel<ID extends Serializable, TYPE extends BaseEntity<ID>>
        implements BaseRepository<ID,TYPE> {

    private final Connection connection;

    public BaseRepositoryImpel(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(TYPE entity) throws SQLException {
        String sql = "INSERT INTO " + getTableName() + " " + getColumnName() + " VALUES"+ getCountOfQuestionMarks();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            fillParamForStatement(preparedStatement, entity, false);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public TYPE findBYId(ID id) throws SQLException {
        String sql = "SELECT * FROM" + getTableName() + "WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, (Integer) id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToEntity(resultSet);
            }
        }

        return null;
    }

    @Override
    public void update(TYPE entity) throws SQLException {
        String sql = "UPDATE " + getTableName() + " SET " + getUpdateQueryParams() + "WHERE ID = " + entity.getId();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            fillParamForStatement(preparedStatement, entity, true);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(ID id) throws SQLException {
        String sql = "DELETE FROM"+getTableName()+"WHERE ID = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,(Integer)id);
            preparedStatement.executeUpdate();
        }
    }


    public abstract String getTableName();

    public abstract String getColumnName();

    public abstract String getCountOfQuestionMarks();

    public abstract void fillParamForStatement(PreparedStatement preparedStatement,
                                               TYPE entity,
                                               Boolean isCountOnly) throws SQLException;

    public abstract TYPE mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    public abstract String getUpdateQueryParams();
}
