package dataaccess.dbmanagers;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDBManager extends DBManager {

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
        statement.execute("INSERT INTO " + TABLE +
                                        " (" + COLUMN_NAME + ", " +
                                               COLUMN_SURNAME + ", " +
                                               COLUMN_PHONE_NUMBER + ", " +
                                               ATTRIBUTE +
                                        " ) VALUES ('" + name + "', " + "'" + surname + "', " +
                                                  "'" + phoneNumber + "', " + "'" + data +"')");
        statement.close();
        connection.close();
    }

    public String selectTable(String phoneNumber) throws SQLException {
        String returnString = "";
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE + " WHERE " +
                COLUMN_PHONE_NUMBER + " ='" + phoneNumber + "'");
        returnString = resultSet.getString(COLUMN_PHONE_NUMBER);

        resultSet.close();
        statement.close();
        connection.close();

        return returnString;
    }


    public static void main(String[] args) {
        DBManager userDBManager = new UserDBManager();
        try {
            userDBManager.deleteContact("2121");
            userDBManager.deleteContact("2332323");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
