package dataaccess.bookchecker.chekings;

import dataaccess.dbmanagers.UserDBManager;
import java.sql.SQLException;

public class UserExisting implements CheckData{
    @Override
    public boolean check(String phoneNumber) {
        UserDBManager userDBManager = new UserDBManager();
        String longNumber = "38" + phoneNumber;
        String shortNumber = phoneNumber.substring(2);
        try {
            Class.forName("org.sqlite.JDBC");
            if (userDBManager.selectTable(phoneNumber) != null ||
                    userDBManager.selectTable(longNumber) != null ||
                    userDBManager.selectTable(shortNumber) != null) {
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
