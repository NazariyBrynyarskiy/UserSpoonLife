package dataaccess.bookchecker.chekings;

import dataaccess.dbmanagers.UserDBManager;
import java.sql.SQLException;

public class UserExisting implements CheckData{
    @Override
    public boolean check(String phoneNumber) {
        UserDBManager userDBManager = new UserDBManager();
        try {
            Class.forName("org.sqlite.JDBC");
            if (phoneNumber.equals(userDBManager.selectTable(phoneNumber)))
                return false;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
