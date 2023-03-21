package dataaccess.bookchecker;

import dataaccess.dbmanagers.UserDBManager;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    @Test
    void process() {
        Checker checker = new Checker();
        assertFalse(checker.process("380975246691"));
    }
//    UserDBManager userDBManager = new UserDBManager();
//        try {
//        assertEquals(userDBManager.selectTable("233"), "233");
//    } catch (
//    SQLException e) {
//        throw new RuntimeException(e);
//    }
}