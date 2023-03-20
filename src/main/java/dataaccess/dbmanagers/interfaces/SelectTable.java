package dataaccess.dbmanagers.interfaces;

import java.sql.SQLException;
import java.util.List;

@FunctionalInterface
public interface SelectTable <T>{
    public List<T> selectTable() throws SQLException;
}
