package com.monsa.ForoHubAlura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ForoHubAluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForoHubAluraApplication.class, args);
	}

}
