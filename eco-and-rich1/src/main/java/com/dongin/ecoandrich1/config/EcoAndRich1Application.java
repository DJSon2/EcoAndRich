package com.dongin.ecoandrich1.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.dongin.ecoandrich1")
public class EcoAndRich1Application {

	public static void main(String[] args) {
		SpringApplication.run(EcoAndRich1Application.class, args);
	}

}
