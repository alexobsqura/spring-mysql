package com.obsqura.example.service;

import com.obsqura.example.entity.Product;
import com.obsqura.example.exception.ProductNotFoundException;
import com.obsqura.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product not found for id: " + id);
        }
        return optionalProduct.get();
    }

    public Product updateProduct(int id, Product product) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product not found for id: " + id);
        }
        Product existing = optionalProduct.get();
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        return repository.save(existing);
    }

    public void deleteProduct(int id) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product not found for id: " + id);
        }
        repository.deleteById(id);
    }
}
