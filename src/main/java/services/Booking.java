package services;

import dataaccess.bookchecker.Checker;
import dataaccess.dbmanagers.UserDBManager;
import dataaccess.dbmanagers.interfaces.DBManagerFields;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Booking {

    private final String nameField;
    private final String surnameField;
    private final String numberField;
    private final String dataField;

    private boolean doesExist;

    public Booking(String nameField, String surnameField, String numberField, String dataField) {
        this.nameField = nameField;
        this.surnameField = surnameField;
        this.numberField = numberField;
        this.dataField = dataField;
    }

    public void book() {
        UserDBManager userDBManager = new UserDBManager();
        Checker checker = new Checker();

        String phoneNumber = numberField;
        if (phoneNumber == null)
            phoneNumber = "";
        if (checker.process(phoneNumber)) {
            try {
                try {
                    Class.forName("org.sqlite.JDBC");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                userDBManager.insertContact(nameField,
                                            surnameField,
                                            phoneNumber,
                                            dataField);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            doesExist = false;
        } else
            doesExist = true;
    }

    public boolean isDoesExist() { return doesExist; }

    public static void main(String[] args) {
//        DBManagerFields fields = new DBManagerFields("", "", "", "");
//        try {
//            Connection connection = DriverManager.getConnection(fields.CONNECTION_STRING);
//            Statement statement = connection.createStatement();
//            statement.executeQuery("DELETE FROM users");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}
