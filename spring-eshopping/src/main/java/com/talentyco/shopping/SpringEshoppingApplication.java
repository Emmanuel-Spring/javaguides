package com.talentyco.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringEshoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEshoppingApplication.class, args);
	}

}
