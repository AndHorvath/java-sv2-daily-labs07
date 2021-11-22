package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HumanTest {

    Human human;

    @BeforeEach
    void initialize() {
        human = new Human("Jack Doe", 2000);
    }

    @Test
    void getNameTest() {
        assertEquals("Jack Doe", human.getName());
    }

    @Test
    void getYearOfBirthTest() {
        assertEquals(2000, human.getYearOfBirth());
    }

    @Test
    void createTestWithInvalidName() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> new Human("Jack", 2000));
        assertEquals("Invalid name.", exception.getMessage());
    }

    @Test
    void createTestWithInvalidYearOfBirthTooOld() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> new Human("Jack Doe", 1900));
        assertEquals("Invalid birth year.", exception.getMessage());
    }

    @Test
    void createTestWithInvalidYearOfBirthTooYoung() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> new Human("Jack Doe", 2022));
        assertEquals("Invalid birth year.", exception.getMessage());
    }
}