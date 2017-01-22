package com.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.restaurant.service.RestaurantSolutionService;

@SpringBootApplication
public class RestaurantSolutionApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RestaurantSolutionApplication.class, args);
		
		RestaurantSolutionService readFileExample = context.getBean(RestaurantSolutionService.class);
		
		long satisfactionSum = readFileExample.findSolution();
		System.out.println("Maximum Satisfaction is :: "+satisfactionSum);
	}
}
