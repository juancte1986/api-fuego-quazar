package com.mercadolibre.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiChallengeApplication.class, args);
	}
}
