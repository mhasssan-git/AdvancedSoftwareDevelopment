package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import products.Product;
import products.ProductService;

import java.util.List;

@RestController
public class ProductCatalogController {
    @Autowired
    ProductService productService;

    @GetMapping(value="/api/product-catalog",produces = "application/json")
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    @GetMapping("/api/product-catalog/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }
    @PostMapping(value = "/api/product-catalog", consumes = "application/json")
    public RedirectView add(@RequestBody Product product) {
        productService.addProduct(product.getProductNumber(),product.getName(),product.getPrice());
        return new RedirectView("/api/product-catalog");
    }
    @DeleteMapping(value = "/api/product-catalog/{id}")
    public void delete(@PathVariable int id) {
        productService.removeProduct(id);
    }
}
