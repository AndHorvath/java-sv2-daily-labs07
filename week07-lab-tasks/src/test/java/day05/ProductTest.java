package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;

    @BeforeEach
    void setUp() {
        product = new Product("rice", LocalDate.of(2021, 10, 10), 100);
    }

    @Test
    void getNameTest() {
        assertEquals("rice", product.getName());
    }

    @Test
    void getDateOfSaleTest() {
        assertEquals(LocalDate.of(2021,10, 10), product.getDateOfSale());
    }

    @Test
    void getPriceTest() {
        assertEquals(100, product.getPrice());
    }

    @Test
    void testToStringTest() {
        assertEquals("rice;2021-10-10;100", product.toString());
    }
}