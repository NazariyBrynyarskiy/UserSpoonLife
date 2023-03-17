package controller.chekings;

import controller.DBManager;
import java.sql.SQLException;

public class UserExisting implements CheckData{
    @Override
    public boolean check(String phoneNumber) {
        try {
            Class.forName("org.sqlite.JDBC");
            if (phoneNumber.equals(DBManager.selectTable(phoneNumber)))
                return false;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
