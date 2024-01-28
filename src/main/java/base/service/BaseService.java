package base.service;

import java.lang.reflect.Type;
import java.sql.SQLException;

public interface BaseService<ID,TYPE>{
     void save(TYPE entity) throws SQLException;
     TYPE findBYId(ID id) throws SQLException;
     void update(TYPE entity) throws SQLException;
     void delete(ID id) throws SQLException;
}
