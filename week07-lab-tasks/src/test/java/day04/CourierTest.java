package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    Courier courier;
    Courier other;
    List<Ride> rides;

    @BeforeEach
    void setUp() {
        courier = new Courier();
        rides = new ArrayList<>(Arrays.asList(
                new Ride(2, 1, 3), new Ride(3, 1, 2)
        ));
        addRides(courier, rides);
    }

    @Test
    void getRidesTest() {
        assertEquals(rides, courier.getRides());
    }

    @Test
    void addRideTest() {
        IllegalArgumentException exception;
        String exceptionMessage = "Ride order mismatch.";

        courier.addRide(new Ride(3, 2, 1));
        assertEquals(3, courier.getRides().size());

        courier.addRide(new Ride(5, 1, 2));
        assertEquals(4, courier.getRides().size());

        exception = assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(4, 1, 2)));
        assertEquals(exceptionMessage, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(5, 3, 2)));
        assertEquals(exceptionMessage, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(6, 2, 2)));
        assertEquals(exceptionMessage, exception.getMessage());

        other = new Courier();
        exception = assertThrows(IllegalArgumentException.class, () -> other.addRide(new Ride(1, 2, 3)));
        assertEquals(exceptionMessage, exception.getMessage());
    }

    // --- private methods ----------------------------------------------------

    private void addRides(Courier courier, List<Ride> rides) {
        for (Ride ride : rides) {
            courier.addRide(ride);
        }
    }
}