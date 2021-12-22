package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class CourierFileManagerTest {

    CourierFileManager courierFileManager;
    Path pathValid;
    Path pathNonExistent;
    Path pathInvalidFormat;

    @BeforeEach
    void setUp() {
        courierFileManager = new CourierFileManager();
        pathValid = Paths.get("src/test/resources/rides.txt");
        pathNonExistent = Paths.get("src/test/resources/rides_.txt");
        pathInvalidFormat = Paths.get("src/test/resources/ridesinvalid.txt");
    }

    @Test
    void createCourierByFileTest() {
        Courier courier = courierFileManager.createCourierByFile(pathValid);
        assertEquals(6, courier.getRides().size());
        assertEquals(1, courier.getRides().get(0).getDayNumber());
        assertEquals(2, courier.getRides().get(1).getRideNumber());
        assertEquals(10, courier.getRides().get(2).getDistance());
    }

    @Test
    void createCourierByFileStateExceptionTest() {
        IllegalStateException stateException = assertThrows(
                IllegalStateException.class, () -> courierFileManager.createCourierByFile(pathNonExistent));
        assertEquals("Cannot read file.", stateException.getMessage());
    }

    @Test
    void createCourierByFileArgumentExceptionTest() {
        IllegalArgumentException argumentException = assertThrows(
                IllegalArgumentException.class, () -> courierFileManager.createCourierByFile(pathInvalidFormat));
        assertEquals("Wrong number format.", argumentException.getMessage());
    }
}