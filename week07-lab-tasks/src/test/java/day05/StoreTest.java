package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    Store store;

    @TempDir
    File temporaryFolder;

    @BeforeEach
    void setUp() {
        store = new Store();
        store.addProduct(new Product("rice", LocalDate.of(2021, 10, 10), 100));
    }

    @Test
    void getSoldProductsTest() {
        assertEquals(1, store.getSoldProducts().size());
        assertEquals("rice", store.getSoldProducts().get(0).getName());
    }

    @Test
    void addProductTest() {
        store.addProduct(new Product("soup", LocalDate.of(2021, 10, 20), 150));
        assertEquals(2, store.getSoldProducts().size());
        assertEquals(LocalDate.of(2021, 10, 20), store.getSoldProducts().get(1).getDateOfSale());

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> store.addProduct(new Product("soup", LocalDate.now().plusYears(1L), 200)));
        assertEquals("Date mismatch.", exception.getMessage());
    }

    @Test
    void writeSoldProductsInMonthToFileTest() throws IOException {
        store.addProduct(new Product("soup", LocalDate.of(2021, 10, 20), 150));
        store.addProduct(new Product("meat", LocalDate.of(2021, 11, 10), 200));

        Path path = temporaryFolder.toPath().resolve("products.csv");
        store.writeSoldProductsInMonthToFile(Month.OCTOBER, path);
        List<String> actualLines = Files.readAllLines(path);
        List<String> expectedLines = Arrays.asList("rice;2021-10-10;100", "soup;2021-10-20;150");
        assertEquals(expectedLines, actualLines);
    }
}