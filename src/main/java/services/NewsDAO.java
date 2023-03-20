package services;

import dataaccess.dbmanagers.implementations.NewsDBManager;
import dataaccess.dbmanagers.entities.News;
import dataaccess.dbmanagers.interfaces.SelectTable;

import java.sql.SQLException;
import java.util.List;

public class NewsDAO {
    List<News> newsList;

    public NewsDAO() {
        SelectTable dbManager = new NewsDBManager();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            newsList = dbManager.selectTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<News> getNewsList() { return newsList; }
}
