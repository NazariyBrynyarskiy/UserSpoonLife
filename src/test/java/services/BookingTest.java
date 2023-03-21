package services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    @Test
    void book() {
        Booking booking = new Booking("naame", "surnaaame", "1380975246691", "3");
        booking.book();
        assertTrue(booking.isDoesExist());
    }
}