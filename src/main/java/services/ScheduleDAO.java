package services;

import dataaccess.dbmanagers.entities.Schedule;
import dataaccess.dbmanagers.implementations.ScheduleDBManager;
import dataaccess.dbmanagers.interfaces.SelectTable;

import java.sql.SQLException;
import java.util.List;

public class ScheduleDAO {
    List<Schedule> daysTimesList;

    public ScheduleDAO() {
        SelectTable dbManager = new ScheduleDBManager();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            daysTimesList = dbManager.selectTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Schedule> getNewsList() { return daysTimesList; }
}
