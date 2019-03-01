package com.madlabs.rev.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.madlabs.rev.java8.modal.Country;
import com.madlabs.rev.java8.modal.TestModal;
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

		Function<Integer, TestModal> test = TestModal::new;
		test.apply(123);

		System.out.println("MainClass");
		List<Country> countryList = worldService.getWolrd();
		countryList.sort(Comparator.comparing(Country::getPopulation).reversed());

		// List All language from Country
		// list All city from country
		// turn the country into continent ****
		// average population of continent
		// use of Primitive summary statics
		// top 3 countries - population, surface ares, gdp - as CSV strings
		// list only capital cities
		// list only official languages
		// max population from each continent
		// Count of countries grouped by 1) continent 2) region (Stream collect & Collectors.groupingBy)

		countryList.stream().collect(Collectors.groupingBy(country -> {
			return country.getContinent();
		}, Collectors.counting())).forEach((String name, Long count) -> {System.out.println("Continent name :"+ name + " Count :"+count);});
		
		System.out.println(" test : "+countryList.stream().collect(Collectors.groupingBy(Country::getContinent, Collectors.groupingBy(Country::getRegion, Collectors.counting()))));

		// Group by Continent, Region (multi level grouping)
		// Sum of population by continent order
		// Print distinct region name & continent
		// highest populated country from each continent/region
		// average population, min popultion, max population group by continent
		// Custom collector to wrap countries into Continent
		Predicate<String> nonEmptyString = (String s) -> !s.isEmpty();

		filter(Arrays.asList("", "", "asfasf"), nonEmptyString);

		Function<Integer, Integer> func1 = x -> x + 1;
		Function<Integer, Integer> func2 = x -> x * 2;
		Function<Integer, Integer> func3 = func1.andThen(func2);

		System.out.println(func3.apply(1));

		System.out.println(func1.andThen(func2).apply(2));

		System.out.println(func1.compose(func2).apply(2));

	}

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for (T s : list) {
			if (p.test(s)) {
				results.add(s);
			}
		}
		return results;
	}

}

@FunctionalInterface
interface Predicate<T> {
	boolean test(T t);
}
