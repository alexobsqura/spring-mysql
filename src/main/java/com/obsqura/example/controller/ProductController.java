package com.obsqura.example.controller;

import com.obsqura.example.entity.Product;
import com.obsqura.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/api/products/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PutMapping("/api/products/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    @DeleteMapping("/api/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
    }
}
