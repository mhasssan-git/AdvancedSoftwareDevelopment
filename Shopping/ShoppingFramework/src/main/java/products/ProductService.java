package products;

public class ProductService {
    ProductDAO productDAO = new ProductDAO();

    public void addProduct(int productNumber, String name, double price){
        productDAO.save(new Product(productNumber, name, price));
    }

    public Product getProduct(int productNumber){
        return productDAO.find(productNumber);
    }

    public void removeProduct(int productNumber){
        productDAO.remove(productNumber);
    }
}
