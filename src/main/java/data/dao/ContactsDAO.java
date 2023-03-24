package data.dao;

import data.dao.entities.Contacts;
import data.interfaces.DAOFields;
import data.interfaces.SelectTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactsDAO extends DAOFields implements SelectTable {
    private final List<Contacts> CONTACTS_LIST;

    public ContactsDAO() {
        super("communication_type", "link", "", "contacts");
        CONTACTS_LIST = new ArrayList<>();
    }

    @Override
    public List<Contacts> selectTable() throws SQLException {
        String communication_type, link;

        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = connection.createStatement();


        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + getTABLE());
        while (resultSet.next()) {
            communication_type = resultSet.getString(getATTRIBUTE_ONE());
            link = resultSet.getString(getATTRIBUTE_TWO());
            CONTACTS_LIST.add(new Contacts(communication_type, link));
        }

        connection.close();
        statement.close();
        resultSet.close();

        return CONTACTS_LIST;
    }

}
