package data.dao;

import data.dao.entities.Trainer;
import data.interfaces.DAOFields;
import data.interfaces.SelectTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainerDAO extends DAOFields implements SelectTable {
    private final List<Trainer> TRAINER_LIST;

    public TrainerDAO() {
        super("name", "surname", "phone_number", "trainers");
        TRAINER_LIST = new ArrayList<>();
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
            TRAINER_LIST.add(new Trainer(name, surname, phoneNumber));
        }

        resultSet.close();
        statement.close();
        connection.close();

        return TRAINER_LIST;
    }

}
