package com.shopAPI.refreshME;

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

}
