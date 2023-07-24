package com.shopAPI.refreshME;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class RefreshMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefreshMeApplication.class, args);
	}

}
