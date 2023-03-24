package service;

import data.interfaces.SelectTable;

import java.sql.SQLException;
public class TrainerManager {
    private final String TRAINERS;

    public TrainerManager() {
        SelectTable trainerDBManager = new data.dao.TrainerDAO();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            TRAINERS = trainerDBManager.selectTable().toString().replace("[", "").replace("]", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTrainers() { return TRAINERS; }
}
