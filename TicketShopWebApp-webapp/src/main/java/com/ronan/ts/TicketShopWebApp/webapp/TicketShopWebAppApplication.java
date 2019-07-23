package com.ronan.ts.TicketShopWebApp.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableReactiveMongoRepositories
@EnableSwagger2
@SpringBootApplication
public class TicketShopWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketShopWebAppApplication.class, args);
	}

}
