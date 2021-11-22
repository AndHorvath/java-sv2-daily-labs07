package day01;

import java.time.LocalDate;

public class Human {

    // --- attributes ---------------------------------------------------------

    private String name;
    private int yearOfBirth;

    // --- constructors -------------------------------------------------------

    public Human(String name, int yearOfBirth) {
        if (!isNameValid(name)) {
            throw new IllegalArgumentException("Invalid name.");
        }
        if (!isYearOfBirthValid(yearOfBirth)) {
            throw new IllegalArgumentException("Invalid birth year.");
        }
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    // --- getters and setters ------------------------------------------------

    public String getName() { return name; }
    public int getYearOfBirth() { return yearOfBirth; }

    // --- private methods ----------------------------------------------------

    private boolean isNameValid(String name) {
        if (name == null || name.trim().length() == 0) {
            return false;
        }
        String auxName = name.trim();
        return auxName.contains(" ");
    }

    private boolean isYearOfBirthValid(int yearOfBirth) {
        int age = LocalDate.now().getYear() - yearOfBirth;

        return age >= 0 && age <= 120;
    }
}