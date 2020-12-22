package repozitory;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Smartphone;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {



    @Test
    void searchBy() {

        ProductManager manager = new ProductManager();


        List produkt =  manager.searchBy("Galaxy");
        Smartphone prod = (Smartphone) produkt.get(0);

        assertEquals(1,produkt.size());
        assertEquals("Samsung", prod.getProducer());

    }
}