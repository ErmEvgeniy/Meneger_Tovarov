package ru.netology.repozitory;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {

    Product book1 = new Book(1, "Война и Мир", 1000, "Лев Толстой");
    Product book2 = new Book(2, "Поколение П", 500, "В.Пелевин");
    Product smartphone = new Smartphone(3, "iPhone", 50000, "Apple");
    Product smartphone2 = new Smartphone(4, "Galaxy", 30000, "Samsung");


    @Test
    void searchBy() {

        ProductManager manager = new ProductManager(book1,book2,smartphone,smartphone2);

        List produkt =  manager.searchBy("Galaxy");
        Smartphone prod = (Smartphone) produkt.get(0);

        assertEquals(1,produkt.size());
        assertEquals("Samsung", prod.getProducer());

    }
}