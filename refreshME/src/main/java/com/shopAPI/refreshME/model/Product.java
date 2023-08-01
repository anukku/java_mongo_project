package com.shopAPI.refreshME.model;

import com.shopAPI.refreshME.other.Sizes;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Products")
public class Product {
    @Id
    private String id;
    private int price;
    private Sizes size;
    private String description;
    private int score;

    public Product(int price, Sizes size, String description, int score) {
        this.price = price;
        this.size = size;
        this.description = description;
        this.score = score;
    }
}
