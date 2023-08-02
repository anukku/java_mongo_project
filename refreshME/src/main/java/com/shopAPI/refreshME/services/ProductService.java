package com.shopAPI.refreshME.services;


import com.shopAPI.refreshME.models.Product;
import com.shopAPI.refreshME.other.Sizes;
import com.shopAPI.refreshME.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void saveProduct(int price, Sizes size, String description, MultipartFile imageFile) {
        byte[] imageBytes;
        try {
            imageBytes = imageFile.getBytes();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read image file.");
        }
        Product product = new Product(price, size, description, imageBytes);
        productRepository.save(product);
    }
}
