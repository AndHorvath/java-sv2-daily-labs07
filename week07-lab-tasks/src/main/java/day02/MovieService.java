package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovieService {

    // --- attributes ---------------------------------------------------------

    private final List<Movie> movieList;

    // --- constructors -------------------------------------------------------

    public MovieService(Path path) {
        movieList = createMovieList(path);
    }

    // --- getters and setters ------------------------------------------------

    public List<Movie> getMovieList() { return movieList; }

    // --- private methods ----------------------------------------------------

    private List<Movie> createMovieList(Path path) {
        List<String> movieListString = readListFromFile(path);
        return transformToMovieList(movieListString);
    }

    private List<String> readListFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot read file.", exception);
        }
    }

    private List<Movie> transformToMovieList(List<String> movieListString) {
        List<Movie> transformedList = new ArrayList<>();
        for (String movieString : movieListString) {
            String[] movieArray = movieString.split(";");
            try {
                transformedList.add(
                        new Movie(movieArray[0], movieArray[2], Integer.parseInt(movieArray[1])));
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException("Wrong number format in file.", exception);
            }
        }
        return transformedList;
    }
}