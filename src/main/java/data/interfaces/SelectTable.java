package data.interfaces;

import java.sql.SQLException;
import java.util.List;

@FunctionalInterface
public interface SelectTable <T>{
    List<T> selectTable() throws SQLException;
}
