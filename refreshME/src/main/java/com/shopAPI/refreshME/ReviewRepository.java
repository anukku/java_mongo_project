package com.shopAPI.refreshME;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository <Review, String> {
}
