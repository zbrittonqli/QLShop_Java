import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

public class OrderTests {
    @Test
    public void CalculateTotalTest(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(UUID.randomUUID(),  "Television", 300.01f));
        products.add(new Product(UUID.randomUUID(),  "Couch", 400.01f));
        products.add(new Product(UUID.randomUUID(),  "Table", 200.01f));

        Order order = new Order();
        order.Products = products;
        order.CalculateTotal();

        Assert.assertEquals(900.03f, order.Total, 0.001);
    }

    @Test
    public void CalculateTotalNoProductsTest(){
        Order order = new Order();

        order.CalculateTotal();

        Assert.assertEquals(0, order.Products.size());
        Assert.assertEquals(0f, order.Total, 0.001);
    }

    @Test
    public void AddProductTest(){
        Order order = new Order();

        order.AddProduct(new Product(UUID.randomUUID(), "Television", 300.01f));

        Assert.assertEquals(1, order.Products.size());
        Assert.assertEquals("Television", order.Products.get(0).Name);
        Assert.assertEquals(300.01f, order.Products.get(0).Price, 0.001);
    }

    @Test
    public void AddManyProductsTest(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(UUID.randomUUID(),  "Television", 300.01f));
        products.add(new Product(UUID.randomUUID(),  "Couch", 400.01f));
        products.add(new Product(UUID.randomUUID(),  "Table", 200.01f));

        Order order = new Order();
        order.AddProduct(products);

        Assert.assertEquals(3, order.Products.size());

        Assert.assertEquals("Television", order.Products.get(0).Name);
        Assert.assertEquals("Couch", order.Products.get(1).Name);
        Assert.assertEquals("Table", order.Products.get(2).Name);

        Assert.assertEquals(300.01f, order.Products.get(0).Price, 0.001);
        Assert.assertEquals(400.01f, order.Products.get(1).Price, 0.001);
        Assert.assertEquals(200.01f, order.Products.get(2).Price, 0.001);
        Assert.assertEquals(900.03f, order.Total, 0.001);
    }
}
