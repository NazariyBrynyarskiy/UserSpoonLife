package dataaccess.dbmanagers;

import dataaccess.dbmanagers.interfaces.DBManagerFields;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDBManager extends DBManagerFields {
    private final String COLUMN_DATA = "data";

    public UserDBManager() {
        super("name", "surname", "phone_number", "users");
    }

    public void insertContact(String name, String surname, String phoneNumber, String data) throws SQLException {
        UserDBManager dbManager = new UserDBManager();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        data = dtf.format(now.plusMonths(Integer.parseInt(data)));

        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO " + dbManager.getTABLE() +
                                        " (" + dbManager.getATTRIBUTE_ONE() + ", " +
                                               dbManager.getATTRIBUTE_TWO() + ", " +
                                               dbManager.getATTRIBUTE_THREE() + ", " +
                                               COLUMN_DATA +
                                        " ) VALUES ('" + name + "', " + "'" + surname + "', " +
                                                  "'" + phoneNumber + "', " + "'" + data +"')");
        statement.close();
        connection.close();
    }

    public String selectTable(String phoneNumber) throws SQLException {
        UserDBManager dbManager = new UserDBManager();
        String returnString = "";
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + dbManager.getTABLE() + " WHERE " +
                dbManager.getATTRIBUTE_THREE() + " ='" + phoneNumber + "'");
        returnString = resultSet.getString(dbManager.getATTRIBUTE_THREE());

        resultSet.close();
        statement.close();
        connection.close();

        return returnString;
    }
}
