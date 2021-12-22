package day04;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    // --- attributes ---------------------------------------------------------

    private List<Ride> rides;

    // --- constructors -------------------------------------------------------

    public Courier() {
        this.rides = new ArrayList<>();
    }

    // --- getters and setters ------------------------------------------------

    public List<Ride> getRides() { return rides; }

    // --- public methods -----------------------------------------------------

    public void addRide(Ride ride) {
        Ride lastRide = rides.size() == 0 ? null : rides.get(rides.size() - 1);
        if (isFirstRideInWeek(lastRide, ride) || ride.isAfter(lastRide)) {
            rides.add(ride);
        } else {
            throw new IllegalArgumentException("Ride order mismatch.");
        }
    }

    // --- private methods ----------------------------------------------------

    private boolean isFirstRideInWeek(Ride lastRide, Ride ride) {
        return lastRide == null && ride.getRideNumber() == 1;
    }
}