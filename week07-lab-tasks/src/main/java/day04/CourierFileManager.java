package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CourierFileManager {

    // --- public methods -----------------------------------------------------

    public Courier createCourierByFile(Path path) {
        List<String> rideStringList;
        try {
            rideStringList = Files.readAllLines(path);
            return createCourierByRideStringList(rideStringList);
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot read file.", exception);
        }
    }

    // --- private methods ----------------------------------------------------

    private Courier createCourierByRideStringList(List<String> rideStringList) {
        List<Ride> rideList = createRideListByRideStringList(rideStringList);
        Courier courier = new Courier();
        for (Ride ride : rideList) {
            courier.addRide(ride);
        }
        return courier;
    }

    private List<Ride> createRideListByRideStringList(List<String> rideStringList) {
        List<Ride> rideList = new ArrayList<>();
        for (String rideString : rideStringList) {
            rideList.add(createRideByRideString(rideString));
        }
        return rideList;
    }

    private Ride createRideByRideString(String rideString) {
        String[] rideArray = rideString.split(" ");
        try {
            return new Ride(
                    Integer.parseInt(rideArray[0]), Integer.parseInt(rideArray[1]), Integer.parseInt(rideArray[2]));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Wrong number format.", exception);
        }
    }
}