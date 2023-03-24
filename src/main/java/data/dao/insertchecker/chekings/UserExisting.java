package data.dao.insertchecker.chekings;

import data.dao.UserInserter;
import java.sql.SQLException;

public class UserExisting implements CheckData{
    @Override
    public boolean check(String phoneNumber) {
        UserInserter userInserter = new UserInserter();
        String longNumber = "38" + phoneNumber;
        String shortNumber = phoneNumber.substring(2);
        try {
            Class.forName("org.sqlite.JDBC");
            if (userInserter.selectTable(phoneNumber) != null ||
                    userInserter.selectTable(longNumber) != null ||
                    userInserter.selectTable(shortNumber) != null) {
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
