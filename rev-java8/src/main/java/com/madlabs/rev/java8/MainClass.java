package com.madlabs.rev.java8;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.madlabs.rev.java8.modal.Country;
import com.madlabs.rev.java8.service.WorldService;

@EnableAutoConfiguration
@SpringBootApplication
public class MainClass implements CommandLineRunner {

	@Autowired
	WorldService worldService;

	public static void main(String[] args) {
		SpringApplication.run(MainClass.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("MainClass");
		List<Country> countryList = worldService.getWolrd();

		
		
		// List All language from Country
		// list All city from country
		// turn the country into continet
		// average population of contient
		// use of Primitive summary statics
		// top 3 countries - population, surface ares, gdp - as CSV strings
		
		
	}

}
