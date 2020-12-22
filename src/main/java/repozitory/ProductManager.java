package repozitory;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    Product[] products = new Product[4];
    Product book1 = new Book(1, "Война и Мир", 1000, "Лев Толстой");
    Product book2 = new Book(2, "Поколение П", 500, "В.Пелевин");
    Product smartphone = new Smartphone(3, "iPhone", 50000, "Apple");
    Product smartphone2 = new Smartphone(4, "Galaxy", 30000, "Samsung");

    public ProductManager() {
        products[0] = book1;
        products[1] = book2;
        products[2] = smartphone;
        products[3] = smartphone2;
    }

    public List searchBy(String text) {

        List<Product> result = new ArrayList();
        for (Product product : products) {
            if (matches(product, text)) {
                result.add(product);
            }
        }
        return result;
    }

    boolean matches(Product product, String search) {

        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().toLowerCase().contains(search.toLowerCase())) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        } else if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getProducer().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        return false;
    }

}

