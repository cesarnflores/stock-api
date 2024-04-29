package com.utoppia.stockapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Entry point for Stock-api
 *
 * @author cesarflores
 *
 */

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Stock API", version = "1.0", description = "API for managing stock data"))
public class StockApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApiApplication.class, args);
	}

}
