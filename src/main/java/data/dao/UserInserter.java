package data.dao;

import data.interfaces.DAOFields;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserInserter extends DAOFields {
    private final String COLUMN_DATA = "data";

    public UserInserter() {
        super("name", "surname",
            "phone_number", "users");
    }

    public void insertContact(String name, String surname, String phoneNumber, String data) throws SQLException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        data = dtf.format(now.plusMonths(Integer.parseInt(data)));

        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO " + getTABLE() +
                                        " (" + getATTRIBUTE_ONE() + ", " +
                                               getATTRIBUTE_TWO() + ", " +
                                               getATTRIBUTE_THREE() + ", " +
                                               COLUMN_DATA +
                                        " ) VALUES ('" + name + "', " + "'" + surname + "', " +
                                                  "'" + phoneNumber + "', " + "'" + data +"')");
        statement.close();
        connection.close();
    }

    public String selectTable(String phoneNumber) throws SQLException {
        String returnString = "";
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + getTABLE() + " WHERE " +
                getATTRIBUTE_THREE() + " ='" + phoneNumber + "'");
        returnString = resultSet.getString(getATTRIBUTE_THREE());

        resultSet.close();
        statement.close();
        connection.close();

        return returnString;
    }
}
