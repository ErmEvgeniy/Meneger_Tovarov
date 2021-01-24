package ru.netology.repozitory;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {


    Product[] products = new Product[0];

    public void addItems (Product item) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        products = tmp;
    }

    public Product[] searchBy(String text) {

        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (matches(product, text)) {
                result.add(product);
            }
        }
        Product[] resultArray = new Product[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
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

