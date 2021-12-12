package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    MovieService movieService;
    Path path;

    @BeforeEach
    void setUp() {
        path = createPath("movies.csv");
        movieService = new MovieService(path);
    }

    @Test
    void getMovieListTest() {
        assertEquals(5, movieService.getMovieList().size());
        assertEquals(
                "Lord Of The Rings; 2002; Peter Jackson",
                movieService.getMovieList().get(3).toString());
    }

    @Test
    void getMovieListTestStateException() {
        path = createPath("movies_.csv");
        IllegalStateException exception = assertThrows(
                IllegalStateException.class, () -> new MovieService(path));
        assertEquals("Cannot read file.", exception.getMessage());
    }

    @Test
    void getMovieListTextFormatException() {
        path = createPath("moviesinvalid.csv");
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> new MovieService(path));
        assertEquals("Wrong number format in file.", exception.getMessage());
    }

    // --- private methods ----------------------------------------------------

    private Path createPath(String fileName) {
        return Paths.get("src/test/resources/" + fileName);
    }
}