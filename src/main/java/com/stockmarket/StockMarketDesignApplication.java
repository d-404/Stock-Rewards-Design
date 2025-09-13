package com.stockmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockMarketDesignApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMarketDesignApplication.class, args);
	}

}
