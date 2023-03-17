import controller.DBManager;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DBManagerTest {

    @Test
    void selectTable() {
        try {
            assertEquals(DBManager.selectTable("233"), "233");
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