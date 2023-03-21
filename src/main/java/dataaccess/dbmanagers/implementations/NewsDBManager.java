package dataaccess.dbmanagers.implementations;

import dataaccess.dbmanagers.entities.News;
import dataaccess.dbmanagers.interfaces.DBManagerFields;
import dataaccess.dbmanagers.interfaces.SelectTable;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class NewsDBManager extends DBManagerFields implements SelectTable {
    private List<News> newsList;
    public NewsDBManager() {
        super("news_title", "news_text", "publication_data", "news");
        newsList = new LinkedList<>();
    }

    @Override
    public List<News> selectTable() throws SQLException {
        NewsDBManager dbManager = new NewsDBManager();
        String title, text, data;

        Connection connection =  DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + dbManager.getTABLE());
        while (resultSet.next()) {
            title = resultSet.getString(dbManager.getATTRIBUTE_ONE());
            text = resultSet.getString(dbManager.getATTRIBUTE_TWO());
            data = resultSet.getString(dbManager.getATTRIBUTE_THREE());
            if (newsList.size() == 4) {
                newsList.add(0, new News(title, text, data));
                newsList.remove(4);
            } else {
                newsList.add(new News(title, text, data));
            }
        }

        connection.close();
        statement.close();
        resultSet.close();

        return newsList;
    }


    public static void main(String[] args) {
        DBManagerFields d = new DBManagerFields("", "", "", "");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String data = dtf.format(now);
        try {
            Connection connection = DriverManager.getConnection(d.CONNECTION_STRING);
            Statement statement = connection.createStatement();
            statement.executeQuery("INSERT INTO news VALUES ('Title 8', 'Text text text text 8', '"+ data +"')");


            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.getMessage();
        }

    }
}
