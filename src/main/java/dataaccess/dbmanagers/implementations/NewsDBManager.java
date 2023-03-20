package dataaccess.dbmanagers.implementations;

import dataaccess.dbmanagers.interfaces.DBManager;
import dataaccess.dbmanagers.interfaces.SelectTable;
import dataaccess.dbmanagers.entities.Trainer;

import java.sql.*;
import java.util.List;

public class NewsDBManager extends DBManager implements SelectTable {
    public NewsDBManager() {
        super("news_title", "news-text", "publication_data", "news");
    }

    @Override
    public List<Trainer> selectTable() throws SQLException {
        DBManager d = new NewsDBManager();

//        String name, surname, phoneNumber;
//        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT " + COLUMN_NAME + ", "
//                + COLUMN_SURNAME + ","
//                + COLUMN_PHONE_NUMBER
//                + " FROM " + TABLE);
//        while (resultSet.next()) {
//            name = resultSet.getString(COLUMN_NAME);
//            surname = resultSet.getString(COLUMN_SURNAME);
//            phoneNumber = resultSet.getString(COLUMN_PHONE_NUMBER);
//            trainerList.add(new Trainer(name, surname, phoneNumber));
//        }

        return null;
    }




}
