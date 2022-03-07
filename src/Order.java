import java.util.ArrayList;
import java.util.List;

public class Order {
    ArrayList<Product> Products = new ArrayList<>();
    float Total;

    public void AddProduct(Product product)
    {
        for (Product item : Products) {
            if (item.Id == product.Id)
            {
                item.Quantity++;
            } else {
                Products.add(product);
            }
        }

        CalculateTotal();
    }

    public void AddProduct(List<Product> productList)
    {
        for (Product product : productList) {
            AddProduct(product);
        }
    }

    public void Cancel()
    {
        Products.clear();
        CalculateTotal();
    }

    public void CalculateTotal()
    {
        Total = 0;

        for (Product product : Products)
        {
            Total += product.Price;
        }
    }
}
