package data.dao;

import data.dao.entities.Schedule;
import data.interfaces.SelectTable;
import data.interfaces.DAOFields;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO extends DAOFields implements SelectTable {
    private final List<Schedule> DAYS_TIMES_LIST;

    public ScheduleDAO() {
        super("day", "time", "", "schedule");
        DAYS_TIMES_LIST = new ArrayList<>();
    }

    @Override
    public List<Schedule> selectTable() throws SQLException {
        String day, time;

        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + getTABLE());
        while (resultSet.next()) {
            day = resultSet.getString(getATTRIBUTE_ONE());
            time = resultSet.getString(getATTRIBUTE_TWO());
            DAYS_TIMES_LIST.add(new Schedule(day, time));
        }

        connection.close();
        statement.close();
        resultSet.close();

        return DAYS_TIMES_LIST;
    }

}
