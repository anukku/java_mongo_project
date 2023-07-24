package com.shopAPI.refreshME;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Reviews")
public class Review {
    @Id
    private String id;
    @Indexed(unique = true)
    private String userName;
    private String content;

    public Review(String userName, String content) {
        this.userName = userName;
        this.content = content;
    }
}
