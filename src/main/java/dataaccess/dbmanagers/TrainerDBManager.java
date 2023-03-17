package dataaccess.dbmanagers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TrainerDBManager extends DBManager{

    private final String TABLE_INFO = "trainers";
    private final String COLUMN_CLIENTS = "clients";

    public TrainerDBManager() {
        super("trainers", "clients");
    }


    @Override
    public void insertContact(String name, String surname, String phoneNumber, String data) throws SQLException {
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO " + TABLE_INFO +
                                        " (" + COLUMN_NAME + ", " +
                                               COLUMN_SURNAME + ", " +
                                               COLUMN_PHONE_NUMBER + ", " +
                                               COLUMN_CLIENTS +
                                        " ) VALUES ('" + name + "', " + "'" + surname + "', " +
                                                   "'" + phoneNumber + "', " + "'" + data +"')");
        statement.close();
        connection.close();
    }


    public static void main(String[] args) {
        TrainerDBManager trainerDBManager = new TrainerDBManager();
        try {
            Connection connection = DriverManager.getConnection(trainerDBManager.CONNECTION_STRING);
            Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS " + trainerDBManager.TABLE_INFO +
                                                           " (" + trainerDBManager.COLUMN_NAME + " TEXT, " +
                                                                  trainerDBManager.COLUMN_SURNAME + " TEXT, " +
                                                                  trainerDBManager.COLUMN_PHONE_NUMBER + " TEXT, " +
                                                                  trainerDBManager.COLUMN_CLIENTS + " TEXT)");
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
