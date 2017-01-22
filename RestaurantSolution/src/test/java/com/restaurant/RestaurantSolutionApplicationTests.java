package com.restaurant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.restaurant.service.RestaurantSolutionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantSolutionApplicationTests {
	
	@Test
	public void contextLoads() {
		ApplicationContext context = SpringApplication.run(RestaurantSolutionApplication.class);
		RestaurantSolutionService readFileExample = context.getBean(RestaurantSolutionService.class);
		long satisfactionSum = readFileExample.findSolution();
		System.out.println("Maximum Satisfaction is :: "+satisfactionSum);
	}
}
