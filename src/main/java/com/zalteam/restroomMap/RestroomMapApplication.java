package com.zalteam.restroomMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestroomMapApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestroomMapApplication.class, args);
	}
}
