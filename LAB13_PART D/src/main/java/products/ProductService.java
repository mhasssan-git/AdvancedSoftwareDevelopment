package products;

import java.util.List;

public class ProductService {
    ProductDAO productDAO = new ProductDAO();

    public void addProduct(int productNumber, String name, double price){
        productDAO.save(new Product(productNumber, name, price));
    }

    public Product getProduct(int productNumber){
        return productDAO.find(productNumber);
    }
    public List<Product> getProducts(){
        return productDAO.getAll();
    }

    public void removeProduct(int productNumber){
        productDAO.remove(productNumber);
    }
}
