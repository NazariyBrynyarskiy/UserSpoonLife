package dataaccess.dbmanagers;

import java.sql.*;

abstract public class DBManager {

    private final String DB_NAME = "user_info.db";
    public final String CONNECTION_STRING = "jdbc:sqlite:/Users/nazariybrynyarsky/Desktop/Java/JavaEE/UserSpoonLife/database/"+DB_NAME;

    protected final String COLUMN_NAME = "name";
    protected final String COLUMN_SURNAME = "surname";
    protected final String COLUMN_PHONE_NUMBER = "phone_number";

    private final String ATTRIBUTE;
    private final String TABLE;

    protected DBManager(String table, String attribute) {
        ATTRIBUTE = attribute;
        TABLE = table;
    }


    abstract public void insertContact(String name, String surname, String phoneNumber, String attribute)
            throws SQLException;


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


    public void deleteContact(String phoneNumber) throws SQLException {
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM " + TABLE +
                                   " WHERE " + COLUMN_PHONE_NUMBER + "='" + phoneNumber + "'");
        statement.close();
        connection.close();
    }


    public void updateData(String phoneNumber, String attribute) throws SQLException {
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        statement.execute("UPDATE " + TABLE + " SET " +
                                          ATTRIBUTE + "='" + attribute + "'" +
                              " WHERE " + COLUMN_PHONE_NUMBER + "='" + phoneNumber + "'");
        statement.close();
        connection.close();
    }
}
