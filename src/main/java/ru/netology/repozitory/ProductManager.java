package ru.netology.repozitory;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    Product[] products = new Product[4];

    public ProductManager(Product book1, Product book2, Product smartphone, Product smartphone2) {
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

