package com.sankalp.sankalp_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sankalp.sankalp_tracker"})
public class SankalpTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SankalpTrackerApplication.class, args);
	}

}
