package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager();

    @Test
    void shouldSearchBookAuthor() {
        Product first = new Book(1, "T1", 25, "A1");
        Product second = new Book(2, "T2", 26, "A2");
        Product third = new Book(3, "T3", 27, "A3");

        manager.add (first);
        manager.add(second);
        manager.add(third);

        Product[] actual = manager.searchBy("A2");
        Product[] expected = {second};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookTitle() {
        Product first = new Book(1, "T1", 25, "A1");
        Product second = new Book(2, "T2", 26, "A2");
        Product third = new Book(3, "T3", 27, "A3");

        manager.add (first);
        manager.add(second);
        manager.add(third);

        Product[] actual = manager.searchBy("T3");
        Product[] expected = {third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookIncompleteAuthor() {
        Product first = new Book(1, "T1", 25, "A1");
        Product second = new Book(2, "T2", 26, "A2");
        Product third = new Book(3, "T3", 27, "A3");

        manager.add (first);
        manager.add(second);
        manager.add(third);

        Product[] actual = manager.searchBy("A");
        Product[] expected = {first, second, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookIncompleteTitle() {
        Product first = new Book(1, "T1", 25, "A1");
        Product second = new Book(2, "T2", 26, "A2");
        Product third = new Book(3, "B3", 27, "A3");

        manager.add (first);
        manager.add(second);
        manager.add(third);

        Product[] actual = manager.searchBy("T");
        Product[] expected = {first, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookCoincidenceTitleAndAuthor() {
        Product first = new Book(1, "T1", 25, "A1");
        Product second = new Book(2, "T3", 26, "A2");
        Product third = new Book(3, "T2", 27, "A3");

        manager.add (first);
        manager.add(second);
        manager.add(third);

        Product[] actual = manager.searchBy("2");
        Product[] expected = {second, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFoundBook() {
        Product first = new Book(1, "T1", 25, "A1");
        Product second = new Book(2, "T2", 26, "A2");
        Product third = new Book(3, "T3", 27, "A3");

        manager.add (first);
        manager.add(second);
        manager.add(third);

        Product[] actual = manager.searchBy("A4");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneManufacturer() {
        Product fourth = new Smartphone(1, "S1", 50, "M1");
        Product fifth = new Smartphone(2, "S2", 53, "M2");
        Product sixth = new Smartphone(3, "S3", 55, "M3");

        manager.add (fourth);
        manager.add(fifth);
        manager.add(sixth);

        Product[] actual = manager.searchBy("M1");
        Product[] expected = {fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneTitle() {
        Product fourth = new Smartphone(1, "S1", 50, "M1");
        Product fifth = new Smartphone(2, "S2", 53, "M2");
        Product sixth = new Smartphone(3, "S3", 55, "M3");

        manager.add (fourth);
        manager.add(fifth);
        manager.add(sixth);

        Product[] actual = manager.searchBy("S3");
        Product[] expected = {sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneCoincidenceManufacturer() {
        Product fourth = new Smartphone(1, "S1", 50, "M1");
        Product fifth = new Smartphone(2, "S2", 53, "I2");
        Product sixth = new Smartphone(3, "S3", 55, "M3");

        manager.add (fourth);
        manager.add(fifth);
        manager.add(sixth);

        Product[] actual = manager.searchBy("M");
        Product[] expected = {fourth, sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneCoincidenceTitle() {
        Product fourth = new Smartphone(1, "S1", 50, "M1");
        Product fifth = new Smartphone(2, "S2", 53, "M2");
        Product sixth = new Smartphone(3, "S3", 55, "M3");

        manager.add (fourth);
        manager.add(fifth);
        manager.add(sixth);

        Product[] actual = manager.searchBy("S");
        Product[] expected = {fourth, fifth, sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneCoincidenceTitleAndManufacturer() {
        Product fourth = new Smartphone(1, "S1", 50, "M1");
        Product fifth = new Smartphone(2, "S2", 51, "M2");
        Product sixth = new Smartphone(3, "S11", 55, "M3");

        manager.add (fourth);
        manager.add(fifth);
        manager.add(sixth);

        Product[] actual = manager.searchBy("1");
        Product[] expected = {fourth, sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFoundSmartphone() {
        Product fourth = new Smartphone(1, "S1", 50, "M1");
        Product fifth = new Smartphone(2, "S2", 53, "M2");
        Product sixth = new Smartphone(3, "S3", 55, "M3");

        manager.add (fourth);
        manager.add(fifth);
        manager.add(sixth);

        Product[] actual = manager.searchBy("Z8");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneBook() {
        Product first = new Book(1, "T1", 25, "A1");
        Product second = new Book(2, "T3", 26, "A2");
        Product third = new Book(3, "T2", 27, "A3");
        Product fourth = new Smartphone(1, "S1", 50, "M2");
        Product fifth = new Smartphone(2, "S2", 53, "M1");
        Product sixth = new Smartphone(3, "S3", 55, "M3");

        manager.add (first);
        manager.add(second);
        manager.add(third);
        manager.add (fourth);
        manager.add(fifth);
        manager.add(sixth);

        Product[] actual = manager.searchBy("1");
        Product[] expected = {first, fourth, fifth};

        assertArrayEquals(expected, actual);
    }
}