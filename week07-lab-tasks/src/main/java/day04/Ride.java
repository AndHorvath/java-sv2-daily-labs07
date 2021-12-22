package day04;

public class Ride {

    // --- attributes ---------------------------------------------------------

    private int dayNumber;
    private int rideNumber;
    private int distance;

    // --- constructors -------------------------------------------------------

    public Ride(int dayNumber, int rideNumber, int distance) {
        this.dayNumber = dayNumber;
        this.rideNumber = rideNumber;
        this.distance = distance;
    }

    // --- getters and setters ------------------------------------------------

    public int getDayNumber() { return dayNumber; }
    public int getRideNumber() { return rideNumber; }
    public int getDistance() { return distance; }

    // --- public methods -----------------------------------------------------

    public boolean isAfter(Ride otherRide) {
        return otherRide != null && (isNewDayRide(otherRide) || isNextRideOnSameDay(otherRide));
    }

    // --- private methods ----------------------------------------------------

    private boolean isNewDayRide(Ride otherRide) {
        return dayNumber > otherRide.getDayNumber() && rideNumber == 1;
    }

    private boolean isNextRideOnSameDay(Ride otherRide) {
        return dayNumber == otherRide.getDayNumber() && rideNumber == otherRide.getRideNumber() + 1;
    }
}