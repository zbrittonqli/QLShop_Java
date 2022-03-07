import java.util.UUID;

public class Product {
    UUID Id;
    String Name;
    float Price;
    int Quantity;

    public Product(UUID id, String name, float price)
    {
        Id = id;
        Name = name;
        Price = price;
        Quantity = 1;
    }
}
