package dataaccess.dbmanagers.implementations;

import dataaccess.dbmanagers.entities.Schedule;
import dataaccess.dbmanagers.interfaces.DBManagerFields;
import dataaccess.dbmanagers.interfaces.SelectTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDBManager extends DBManagerFields implements SelectTable {
    private final List<Schedule> daysTimesList;

    public ScheduleDBManager() {
        super("day", "time", "", "schedule");
        daysTimesList = new ArrayList<>();
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
            daysTimesList.add(new Schedule(day, time));
        }

        connection.close();
        statement.close();
        resultSet.close();

        return daysTimesList;
    }

}
