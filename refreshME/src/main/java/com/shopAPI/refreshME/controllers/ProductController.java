package com.shopAPI.refreshME.controllers;


import com.shopAPI.refreshME.services.ProductService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    ProductService productService;
    public ProductController(ProductService productService){this.productService = productService;}


}
