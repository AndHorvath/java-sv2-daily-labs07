package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RideTest {

    Ride ride;
    Ride another;

    @BeforeEach
    void setUp() {
        ride = new Ride(1, 2, 3);
    }

    @Test
    void getDayNumberTest() {
        assertEquals(1, ride.getDayNumber());
    }

    @Test
    void getRideNumberTest() {
        assertEquals(2, ride.getRideNumber());
    }

    @Test
    void getDistanceTest() {
        assertEquals(3, ride.getDistance());
    }

    @Test
    void isAfterTest() {
        assertFalse(ride.isAfter(ride));

        another = new Ride(3, 1, 2);
        assertTrue(another.isAfter(ride));

        another = new Ride(1, 3, 2);
        assertTrue(another.isAfter(ride));

        another = new Ride(1, 4, 3);
        assertFalse(another.isAfter(ride));
    }
}