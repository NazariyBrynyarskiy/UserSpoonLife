package dataaccess.checker.chekings;

import dataaccess.dbmanagers.DBManager;
import dataaccess.dbmanagers.UserDBManager;
import java.sql.SQLException;

public class UserExisting implements CheckData{
    @Override
    public boolean check(String phoneNumber) {
        DBManager dbManager = new UserDBManager();
        try {
            Class.forName("org.sqlite.JDBC");
            if (phoneNumber.equals(dbManager.selectTable(phoneNumber)))
                return false;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
