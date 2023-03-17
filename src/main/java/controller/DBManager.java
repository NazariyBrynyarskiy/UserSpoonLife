package controller;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DBManager {

    private static final String DB_NAME = "user_info.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/nazariybrynyarsky/Desktop/Java/JavaEE/SpoonLife/SpoonLife/database/"+DB_NAME;

    private static final String TABLE_INFO = "users";

    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SURNAME = "surname";
    private static final String COLUMN_PHONE_NUMBER = "phone_number";
    private static final String COLUMN_DATA = "data";

    private static void addTable() {
        try {
            Connection connection = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_INFO +
                    " (" + COLUMN_NAME + " TEXT, " +
                           COLUMN_SURNAME + " TEXT, " +
                           COLUMN_PHONE_NUMBER + " TEXT, " +
                           COLUMN_DATA + " TEXT)");
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public static String selectTable(String phoneNumber) throws SQLException {
        String returnString = "";
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_INFO + " WHERE " +
                COLUMN_PHONE_NUMBER + " ='" + phoneNumber + "'");
        returnString = resultSet.getString(COLUMN_PHONE_NUMBER);

        resultSet.close();
        statement.close();
        connection.close();

        return returnString;
    }


    public static void insertContact(String name, String surname, String phoneNumber, String data) throws SQLException {
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
                                        ") VALUES ('" + name + "', " + "'" + surname + "', " +
                                                  "'" + phoneNumber + "', " + "'" + data +"')");
        statement.close();
        connection.close();
    }


    public static void deleteContact(String phoneNumber) throws SQLException {
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM " + TABLE_INFO +
                                   " WHERE " + COLUMN_PHONE_NUMBER + "='" + phoneNumber + "'");
        statement.close();
        connection.close();
    }


    private static void deleteContact() throws SQLException {
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM " + TABLE_INFO);
        statement.close();
        connection.close();
    }


    public static void updateData(String phoneNumber, String data) throws SQLException {
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        statement.execute("UPDATE " + TABLE_INFO + " SET " +
                                          COLUMN_DATA + "='" + data + "'" +
                              " WHERE " + COLUMN_PHONE_NUMBER + "='" + phoneNumber + "'");
        statement.close();
        connection.close();
    }


    public static void main(String[] args) {
        try {
            deleteContact();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
