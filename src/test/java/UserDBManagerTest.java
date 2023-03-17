import dataaccess.dbmanagers.UserDBManager;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDBManagerTest {

    @Test
    void selectTable() {
        UserDBManager userDBManager = new UserDBManager();
        try {
            assertEquals(userDBManager.selectTable("233"), "233");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void insertContact() {
    }

    @Test
    void deleteContact() {
    }

    @Test
    void updateData() {
    }
}