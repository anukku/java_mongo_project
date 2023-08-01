package com.shopAPI.refreshME.repositories;

import com.shopAPI.refreshME.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends MongoRepository <Review, String> {

}
