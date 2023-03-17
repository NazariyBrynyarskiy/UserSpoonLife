package dataaccess.dbmanagers;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDBManager extends DBManager {

    private final String TABLE_INFO = "users";
    private final String COLUMN_DATA = "data";

    public UserDBManager() {
        super("users", "data");
    }


    @Override
    public void insertContact(String name, String surname, String phoneNumber, String data) throws SQLException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        data = dtf.format(now.plusMonths(Integer.parseInt(data)));

        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO " + TABLE_INFO +
                                        " (" + COLUMN_NAME + ", " +
                                               COLUMN_SURNAME + ", " +
                                               COLUMN_PHONE_NUMBER + ", " +
                                               COLUMN_DATA +
                                        " ) VALUES ('" + name + "', " + "'" + surname + "', " +
                                                  "'" + phoneNumber + "', " + "'" + data +"')");
        statement.close();
        connection.close();
    }


    public static void main(String[] args) {

    }


}
