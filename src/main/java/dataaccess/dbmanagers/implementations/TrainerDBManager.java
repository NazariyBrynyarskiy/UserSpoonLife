package dataaccess.dbmanagers.implementations;

import dataaccess.dbmanagers.interfaces.DBManagerFields;
import dataaccess.dbmanagers.interfaces.SelectTable;
import dataaccess.dbmanagers.entities.Trainer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainerDBManager extends DBManagerFields implements SelectTable {
    private final List<Trainer> trainerList;

    public TrainerDBManager() {
        super("name", "surname", "phone_number", "trainers");
        trainerList = new ArrayList<>();
    }

    @Override
    public List<Trainer> selectTable() throws SQLException {
        String name, surname, phoneNumber;
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT " + getATTRIBUTE_ONE() + ", "
                                                                   + getATTRIBUTE_TWO() + ","
                                                                   + getATTRIBUTE_THREE()
                                                        + " FROM " + getTABLE());
        while (resultSet.next()) {
            name = resultSet.getString(getATTRIBUTE_ONE());
            surname = resultSet.getString(getATTRIBUTE_TWO());
            phoneNumber = resultSet.getString(getATTRIBUTE_THREE());
            trainerList.add(new Trainer(name, surname, phoneNumber));
        }

        resultSet.close();
        statement.close();
        connection.close();

        return trainerList;
    }

}
