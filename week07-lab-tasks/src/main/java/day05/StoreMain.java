package day05;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;

public class StoreMain {

    public static void main(String[] args) {
        Store store = new Store();

        store.addProduct(new Product("rice", LocalDate.of(2021, 10, 10), 100));
        store.addProduct(new Product("soup", LocalDate.of(2021, 10, 20), 150));
        store.addProduct(new Product("meat", LocalDate.of(2021, 11, 10), 200));

        store.writeSoldProductsInMonthToFile(Month.OCTOBER, Path.of("src/main/resources/products.csv"));
    }
}