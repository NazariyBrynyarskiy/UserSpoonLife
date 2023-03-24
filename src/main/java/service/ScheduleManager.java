package service;

import data.dao.entities.Schedule;
import data.interfaces.SelectTable;

import java.sql.SQLException;
import java.util.List;

public class ScheduleManager {
    private final List<Schedule> DAYS_TIMES_LIST;

    public ScheduleManager() {
        SelectTable dbManager = new data.dao.ScheduleDAO();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            DAYS_TIMES_LIST = dbManager.selectTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Schedule> getDaysTimesList() { return DAYS_TIMES_LIST; }
}
