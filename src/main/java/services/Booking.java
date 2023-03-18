package services;

import dataaccess.checker.Checker;
import dataaccess.dbmanagers.DBManager;
import dataaccess.dbmanagers.UserDBManager;

import java.sql.SQLException;

public class Booking {

    private final String nameField;
    private final String surnameField;
    private final String numberField;
    private final String dataField;

    public Booking(String nameField, String surnameField, String numberField, String dataField) {
        this.nameField = nameField;
        this.surnameField = surnameField;
        this.numberField = numberField;
        this.dataField = dataField;
    }

    public void book() {
        DBManager userDBManager = new UserDBManager();
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
        }
    }
}
