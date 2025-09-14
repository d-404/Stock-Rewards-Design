package com.stockmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockRewardsDesignApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockRewardsDesignApplication.class, args);
	}

}
