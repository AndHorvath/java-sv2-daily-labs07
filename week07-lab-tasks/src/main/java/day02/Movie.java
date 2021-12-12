package day02;

public class Movie {

    // --- attributes ---------------------------------------------------------

    private String title;
    private String director;
    private int yearOfProduction;

    // --- constructors -------------------------------------------------------

    public Movie(String title, String director, int yearOfProduction) {
        this.title = title;
        this.director = director;
        this.yearOfProduction = yearOfProduction;
    }

    // --- getters and setters ------------------------------------------------

    public String getTitle() { return title; }
    public String getDirector() { return director; }
    public int getYearOfProduction() { return yearOfProduction; }

    // --- public methods -----------------------------------------------------

    @Override
    public String toString() {
        return title + "; " + yearOfProduction + "; " + director;
    }
}