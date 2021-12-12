package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Store {

    // --- attributes ---------------------------------------------------------

    private List<Product> soldProducts;

    // --- constructors -------------------------------------------------------

    public Store() {
        soldProducts = new ArrayList<>();
    }

    // --- getters and setters ------------------------------------------------

    public List<Product> getSoldProducts() { return soldProducts; }

    // --- public methods -----------------------------------------------------

    public void addProduct(Product product) {
        validateParameter(product);
        soldProducts.add(product);
    }

    public void writeSoldProductsInMonthToFile(Month month, Path path) {
        List<String> soldProductToWrite = createListToWrite(month);
        writeToFile(soldProductToWrite, path);
    }

    // --- private methods ----------------------------------------------------

    private void validateParameter(Product product) {
        if (product.getDateOfSale().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date mismatch.");
        }
    }

    private List<String> createListToWrite(Month month) {
        List<String> listToWrite = new ArrayList<>();
        for (Product product : soldProducts) {
            if (product.getDateOfSale().getMonth() == month) {
                listToWrite.add(product.toString());
            }
        }
        return listToWrite;
    }

    private void writeToFile(List<String> listToWrite, Path path) {
        try {
            Files.write(path, listToWrite);
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot write file.");
        }
    }
}