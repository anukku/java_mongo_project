package com.shopAPI.refreshME.repositories;

import com.shopAPI.refreshME.models.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository <Review, String> {

}
