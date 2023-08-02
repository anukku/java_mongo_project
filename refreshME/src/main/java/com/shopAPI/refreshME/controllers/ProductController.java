package com.shopAPI.refreshME.controllers;


import com.shopAPI.refreshME.models.Product;
import com.shopAPI.refreshME.other.Sizes;
import com.shopAPI.refreshME.services.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {
    ProductService productService;
    public ProductController(ProductService productService){this.productService = productService;}

    @GetMapping("/product/getAll")
    public List<Product> getAllProducts(){return productService.getAllProducts();}

    @PostMapping("/product/add")
    public ResponseEntity<String> addProduct(
            @RequestParam("price") int price,
            @RequestParam("size") Sizes size,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile imageFile) {
        productService.saveProduct(price, size, description, imageFile);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully.");
    }
}
