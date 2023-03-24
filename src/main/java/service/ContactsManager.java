package service;

import data.dao.ContactsDAO;
import data.dao.entities.Contacts;
import data.dao.entities.Schedule;
import data.interfaces.SelectTable;

import java.sql.SQLException;
import java.util.List;

public class ContactsManager {
    private final List<Contacts> CONTACTS_LIST;

    public ContactsManager() {
        SelectTable dbManager = new ContactsDAO();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            CONTACTS_LIST = dbManager.selectTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contacts> getContactsList() { return CONTACTS_LIST; }
}
