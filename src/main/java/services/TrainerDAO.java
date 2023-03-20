package services;

import dataaccess.dbmanagers.implementations.TrainerDBManager;
import dataaccess.dbmanagers.interfaces.SelectTable;

import java.sql.SQLException;
public class TrainerDAO {
    private String trainerList;

    public TrainerDAO() {
        SelectTable trainerDBManager = new TrainerDBManager();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            trainerList = trainerDBManager.selectTable().toString().replace("[", "").replace("]", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTrainerList() { return trainerList; }
}
