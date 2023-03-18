package dataaccess.dbmanagers;

import dataaccess.dbmanagers.entities.Trainer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainerDBManager extends DBManager{
    List<Trainer> trainerList;

    public TrainerDBManager() {
        super("trainers", "clients");
        trainerList = new ArrayList<>();
    }

    @Override
    public void insertContact(String name, String surname, String phoneNumber, String clients) throws SQLException {
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO " + TABLE +
                                        " (" + COLUMN_NAME + ", " +
                                               COLUMN_SURNAME + ", " +
                                               COLUMN_PHONE_NUMBER + ", " +
                                               ATTRIBUTE +
                                        " ) VALUES ('" + name + "', " + "'" + surname + "', " +
                                                   "'" + phoneNumber + "', " + "'" + clients +"')");
        statement.close();
        connection.close();
    }

    public List<Trainer> selectTable() throws SQLException {
        String name, surname, phoneNumber;
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT " + COLUMN_NAME + ", "
                                                                   + COLUMN_SURNAME + ","
                                                                   + COLUMN_PHONE_NUMBER
                                                                   + " FROM " + TABLE);
        while (resultSet.next()) {
            name = resultSet.getString(COLUMN_NAME);
            surname = resultSet.getString(COLUMN_SURNAME);
            phoneNumber = resultSet.getString(COLUMN_PHONE_NUMBER);
            trainerList.add(new Trainer(name, surname, phoneNumber));
        }

        resultSet.close();
        statement.close();
        connection.close();

        return trainerList;
    }

    public static void main(String[] args) {
        TrainerDBManager trainerDBManager = new TrainerDBManager();
//        try {
//            Connection connection = DriverManager.getConnection(trainerDBManager.CONNECTION_STRING);
//            Statement statement = connection.createStatement();
//
//            statement.execute("CREATE TABLE IF NOT EXISTS " + trainerDBManager.TABLE +
//                                                           " (" + trainerDBManager.COLUMN_NAME + " TEXT, " +
//                                                                  trainerDBManager.COLUMN_SURNAME + " TEXT, " +
//                                                                  trainerDBManager.COLUMN_PHONE_NUMBER + " TEXT, " +
//                                                                  trainerDBManager.ATTRIBUTE + " TEXT)");
//            statement.close();
//            connection.close();
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
        try {
            trainerDBManager.insertContact("Chupapi", "Munanu", "380328283993", "");
            trainerDBManager.insertContact("Beba", "Hebra", "33443433384", "");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
