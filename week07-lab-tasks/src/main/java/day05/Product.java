package day05;

import java.time.LocalDate;

public class Product {

    // --- attributes ---------------------------------------------------------

    private String name;
    private LocalDate dateOfSale;
    private int price;

    // --- constructors -------------------------------------------------------

    public Product(String name, LocalDate dateOfSale, int price) {
        this.name = name;
        this.dateOfSale = dateOfSale;
        this.price = price;
    }

    // --- getters and setters ------------------------------------------------

    public String getName() {
        return name;
    }
    public LocalDate getDateOfSale() {
        return dateOfSale;
    }
    public int getPrice() {
        return price;
    }

    // --- public methods -----------------------------------------------------

    @Override
    public String toString() {
        String colon = ";";
        return name + colon + dateOfSale + colon + price;
    }
}