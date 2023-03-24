package service;

import data.dao.insertchecker.Checker;
import data.dao.UserInserter;

import java.sql.SQLException;

public class BookingManager {

    private final String NAME_FIELD;
    private final String SURNAME_FIELD;
    private final String NUMBER_FIELD;
    private final String DATA_FIELD;

    public BookingManager(String NAME_FIELD, String SURNAME_FIELD, String NUMBER_FIELD, String DATA_FIELD) {
        this.NAME_FIELD = NAME_FIELD;
        this.SURNAME_FIELD = SURNAME_FIELD;
        this.NUMBER_FIELD = NUMBER_FIELD;
        this.DATA_FIELD = DATA_FIELD;
    }

    public void book() throws SQLException, ClassNotFoundException{
        UserInserter userInserter = new UserInserter();
        Checker checker = new Checker();

        String phoneNumber = NUMBER_FIELD;
        if (phoneNumber == null)
            phoneNumber = "";
        if (checker.process(phoneNumber)) {
            Class.forName("org.sqlite.JDBC");
            userInserter.insertContact(NAME_FIELD,
                                       SURNAME_FIELD,
                                       phoneNumber,
                                       DATA_FIELD);
        }
    }

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
