package ru.netology.repozitory;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {

    Product book1 = new Book(1, "Война и Мир", 1000, "Лев Толстой");
    Product book2 = new Book(2, "Поколение П", 50000, "В.Пелевин");
    Product book3 = new Book(3, "Оно", 300, "С.Кинг");
    Product book4 = new Book(4, "1984", 200, "Джордж Оруэлл");
    Product book5 = new Book(5, "Темная башня", 500, "С.Кинг");
    Product smartphone1 = new Smartphone(6, "iPhone", 50000, "Apple");
    Product smartphone2 = new Smartphone(7, "Galaxy", 30000, "Samsung");
    Product smartphone3 = new Smartphone(8, "1984", 20000, "HUAWEI");
    Product smartphone4 = new Smartphone(9, "Mi 9T", 10000, "Xiaomi");
    Product smartphone5 = new Smartphone(10, "Blade A7 ", 25000, "ZTE");


    @Test
     void addAndSearchBy() {

        ProductManager manager = new ProductManager();

        manager.addItems(book1);
        manager.addItems(book2);
        manager.addItems(book3);
        manager.addItems(book4);
        manager.addItems(book5);
        manager.addItems(smartphone1);
        manager.addItems(smartphone2);
        manager.addItems(smartphone3);
        manager.addItems(smartphone4);
        manager.addItems(smartphone5);

        Product[] produkt = manager.searchBy("Galaxy");
        Smartphone prod = (Smartphone) produkt[0];

        assertEquals(1, produkt.length);
        assertEquals("Samsung", prod.getProducer());

        //тестирование метода поиска
        Product[] arraySearchedProducts = manager.searchBy("Galaxy");
        Product[] expectedProducts = new Product[]{smartphone2};

        assertArrayEquals(expectedProducts, arraySearchedProducts);
        
    }

    @Test
    void SearchByMoreItems() {

        ProductManager manager1 = new ProductManager();

        manager1.addItems(book1);
        manager1.addItems(book2);
        manager1.addItems(book3);
        manager1.addItems(book4);
        manager1.addItems(book5);
        manager1.addItems(smartphone1);
        manager1.addItems(smartphone2);
        manager1.addItems(smartphone3);
        manager1.addItems(smartphone4);
        manager1.addItems(smartphone5);

        Product[] produkt = manager1.searchBy("С.Кинг");
        Book prod = (Book) produkt[0];

        assertEquals(2, produkt.length);
        assertEquals("С.Кинг", prod.getAuthor());

        //тестирование метода поиска
        Product[] arraySearchedProducts = manager1.searchBy("С.Кинг");
        Product[] expectedProducts = new Product[]{book3, book5};

        assertArrayEquals(expectedProducts, arraySearchedProducts);
    }

    @Test
    void SearchByNull() {

        ProductManager manager2 = new ProductManager();

        manager2.addItems(book1);
        manager2.addItems(book2);
        manager2.addItems(book3);
        manager2.addItems(book4);
        manager2.addItems(book5);
        manager2.addItems(smartphone1);
        manager2.addItems(smartphone2);
        manager2.addItems(smartphone3);
        manager2.addItems(smartphone4);
        manager2.addItems(smartphone5);

        Product[] produkt = manager2.searchBy("Анна Каренина");
        assertEquals(0, produkt.length);

        //тестирование метода поиска
        Product[] arraySearchedProducts = manager2.searchBy("Анна Каренина");
        Product[] expectedProducts = new Product[]{};

        assertArrayEquals(expectedProducts, arraySearchedProducts);

    }

    @Test
    void SearchByDifferentItems() {

        ProductManager manager3 = new ProductManager();

        manager3.addItems(book1);
        manager3.addItems(book2);
        manager3.addItems(book3);
        manager3.addItems(book4);
        manager3.addItems(book5);
        manager3.addItems(smartphone1);
        manager3.addItems(smartphone2);
        manager3.addItems(smartphone3);
        manager3.addItems(smartphone4);
        manager3.addItems(smartphone5);

        Product[] produkt = manager3.searchBy("1984");
        assertEquals(2, produkt.length);

        //тестирование метода поиска
        Product[] arraySearchedProducts = manager3.searchBy("1984");
        Product[] expectedProducts = new Product[]{book4,smartphone3};

        assertArrayEquals(expectedProducts, arraySearchedProducts);
    }
}
