package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    Movie movie;

    @BeforeEach
    void setUp() {
        movie = new Movie("Good Film", "Jack Doe", 2020);
    }

    @Test
    void getTitleTest() {
        assertEquals("Good Film", movie.getTitle());
    }

    @Test
    void getDirectorTest() {
        assertEquals("Jack Doe", movie.getDirector());
    }

    @Test
    void getYearOfProductionTest() {
        assertEquals(2020, movie.getYearOfProduction());
    }

    @Test
    void testToStringTest() {
        assertEquals("Good Film; 2020; Jack Doe", movie.toString());
    }
}