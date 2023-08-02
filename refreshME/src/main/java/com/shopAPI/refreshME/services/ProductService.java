package com.shopAPI.refreshME.services;


import com.shopAPI.refreshME.models.Product;
import com.shopAPI.refreshME.other.Sizes;
import com.shopAPI.refreshME.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService (ProductRepository productRepository){this.productRepository = productRepository;}

    public List<Product> getAllProducts() {return productRepository.findAll();}

    public void saveProduct(int price, Sizes size, String description, byte[] image){
        productRepository.save(new Product(price, size, description, image));
    }


}
