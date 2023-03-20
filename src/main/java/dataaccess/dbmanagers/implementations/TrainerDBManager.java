package dataaccess.dbmanagers.implementations;

import dataaccess.dbmanagers.interfaces.DBManagerFields;
import dataaccess.dbmanagers.interfaces.SelectTable;
import dataaccess.dbmanagers.entities.Trainer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainerDBManager extends DBManagerFields implements SelectTable {
    private List<Trainer> trainerList;

    public TrainerDBManager() {
        super("name", "surname", "phone_number", "trainers");
        trainerList = new ArrayList<>();
    }

    @Override
    public List<Trainer> selectTable() throws SQLException {
        TrainerDBManager dbManager = new TrainerDBManager();
        String name, surname, phoneNumber;
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT " + dbManager.getATTRIBUTE_ONE() + ", "
                                                                   + dbManager.getATTRIBUTE_TWO() + ","
                                                                   + dbManager.getATTRIBUTE_THREE()
                                                        + " FROM " + dbManager.getTABLE());
        while (resultSet.next()) {
            name = resultSet.getString(dbManager.getATTRIBUTE_ONE());
            surname = resultSet.getString(dbManager.getATTRIBUTE_TWO());
            phoneNumber = resultSet.getString(dbManager.getATTRIBUTE_THREE());
            trainerList.add(new Trainer(name, surname, phoneNumber));
        }

        resultSet.close();
        statement.close();
        connection.close();

        return trainerList;
    }

}
