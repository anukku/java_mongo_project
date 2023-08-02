package com.shopAPI.refreshME.models;

import com.shopAPI.refreshME.other.Sizes;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Data
@Document(collection = "Products")
public class Product {
    @Id
    private String id;
    private int price;
    private Sizes size;
    private String description;
    private byte[] image;

    public Product(int price, Sizes size, String description, byte[] image) {
        this.price = price;
        this.size = size;
        this.description = description;
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Sizes getSize() {
        return size;
    }

    public void setSize(Sizes size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", size=" + size +
                ", description='" + description + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
