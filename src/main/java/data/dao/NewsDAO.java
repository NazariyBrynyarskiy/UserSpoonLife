package data.dao;

import data.dao.entities.News;
import data.interfaces.DAOFields;
import data.interfaces.SelectTable;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class NewsDAO extends DAOFields implements SelectTable {
    private final List<News> NEWS_LIST;
    public NewsDAO() {
        super("news_title", "news_text",
            "publication_data", "news");
        NEWS_LIST = new LinkedList<>();
    }

    @Override
    public List<News> selectTable() throws SQLException {
        String title, text, data;

        Connection connection =  DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + getTABLE());
        while (resultSet.next()) {
            title = resultSet.getString(getATTRIBUTE_ONE());
            text = resultSet.getString(getATTRIBUTE_TWO());
            data = resultSet.getString(getATTRIBUTE_THREE());
            if (NEWS_LIST.size() == 4) {
                NEWS_LIST.add(0, new News(title, text, data));
                NEWS_LIST.remove(4);
            } else {
                NEWS_LIST.add(new News(title, text, data));
            }
        }

        connection.close();
        statement.close();
        resultSet.close();

        return NEWS_LIST;
    }

}
