package products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAO {
    private Map<Integer, Product> products = new HashMap<Integer, Product>();

    public void save(Product product){
        products.put(product.getProductNumber(), product);
    }

    public Product find(int productNumber){
        return products.get(productNumber);
    }
    public List<Product> getAll(){
        return new ArrayList<Product>(products.values());
    }

    public void remove(int productNumber){
        products.remove(productNumber);
    }
}
