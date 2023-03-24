package service;

import data.dao.entities.News;
import data.interfaces.SelectTable;

import java.sql.SQLException;
import java.util.List;

public class NewsManager {
    private final List<News> NEWS_LIST;

    public NewsManager() {
        SelectTable dbManager = new data.dao.NewsDAO();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            NEWS_LIST = dbManager.selectTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<News> getNewsList() { return NEWS_LIST; }
}
