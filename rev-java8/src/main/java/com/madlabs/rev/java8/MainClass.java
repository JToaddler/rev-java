package com.madlabs.rev.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.madlabs.rev.java8.modal.Continent;
import com.madlabs.rev.java8.modal.Country;
import com.madlabs.rev.java8.modal.Language;
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

		new TestQuize().prepare(countryList);
		/*
		 * List<Country> asianCountry = filter(countryList, new GenericCountryFilter(),
		 * "Asia"); System.out.println("Asian Country :" + asianCountry);
		 * 
		 * String regionName = "Asia"; countryList.stream().filter((country) -> { return
		 * regionName.equals(country.getContinent()); }).collect(Collectors.toList());
		 * 
		 * BiFunction<List<Country>, String, List<Country>> regionFilter = (a, b) -> {
		 * return a.stream().filter((country) -> {
		 * 
		 * return b.equals(country.getContinent()); }).collect(Collectors.toList());
		 * 
		 * }; System.out.println("North America" + regionFilter.apply(countryList,
		 * "North America")); String testVar = "s";
		 * 
		 * CountyFilter<List<Country>, String, List<Country>> customFilter = (a, b) -> {
		 * return a.stream().filter((country) -> { return
		 * b.equals(country.getContinent()); }).collect(Collectors.toList()); };
		 * test(customFilter, countryList); System.out.println("Europe" +
		 * customFilter.filterCountry(countryList, "Europe"));
		 * 
		 * List<String> asianCountryResult =
		 * countryList.stream().map(Country::getName).collect(Collectors.toList());
		 * 
		 * // Method Referencing asianCountryResult.sort(String::compareToIgnoreCase);
		 * 
		 * countryList.stream().map(Country::getName).distinct().collect(Collectors.
		 * toList());
		 * 
		 * List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		 * 
		 * System.out.println(numbers.stream().map(n -> n *
		 * n).collect(Collectors.toList()));
		 * 
		 * System.out.println(numbers.stream().map(n -> n * 1).limit(3).reduce(0, (a, b)
		 * -> { System.out.println(a + " + " + b + " => " + (a + b)); return a + b; }));
		 * 
		 */

	}

	public static void test(CountyFilter<List<Country>, String, List<Country>> regionFilter,
			List<Country> countryList) {

		regionFilter.filterCountry(countryList, "Asia");

	}

	public List<Country> filter(List<Country> countryList, GenericCountryFilter filter, String name) {

		return filter.filterCountry(countryList, name);
	}

}

interface CountyFilter<T, U, R> {
	public R filterCountry(T t, U u);
}

interface Test<T> {
	public T filterCountry(T t, T u, T x);
}

interface CustomFilterFilter {
	public boolean filterCountry(Country country, String regionName);
}

class GenericCountryFilter implements CountyFilter {

	public List<Country> filterCountry(List<Country> countryList, String regionName) {

		List<Country> countryResult = new ArrayList<Country>();
		countryList.stream().forEach((country) -> {

			if (regionName.equalsIgnoreCase(country.getContinent()))
				countryResult.add(country);
		});
		return countryResult;
	}
}

class TestQuize {

	// list All city from country
	// turn the country into continent ****
	// average population of continent
	// use of Primitive summary statics
	// top 3 countries - population, surface ares, gdp - as CSV strings
	// list only capital cities
	// list only official languages
	// max population from each continent
	// Count of countries grouped by 1) continent 2) region (Stream collect &
	// Collectors.groupingBy)

	// Group by Continent, Region (multi level grouping)
	// Sum of population by continent order
	// Print distinct region name & continent
	// highest populated country from each continent/region
	// average population, min popultion, max population group by continent
	// Custom collector to wrap countries into Continent
	// print string in one line
	// country with Max GDP
	// country with max pop
	// Group countries by contitnet & no of countries in contient
	// Max GDP from each continent
	// max population from each continent

	public void prepare(List<Country> countryList) {

		System.out.println("==============================");

		// List All language from Country
		System.out.println(" Distinct Language :" + countryList.stream().flatMap((country) -> {
			return country.getLanguage().stream().map(Language::getLanguage);
		}).distinct().collect(Collectors.toList()));

		System.out.println(" Distinct Language count :" + countryList.stream().flatMap((country) -> {
			return country.getLanguage().stream().map(Language::getLanguage);
		}).distinct().count());

		System.out.println(
				"Distinct  City +" + countryList.stream().flatMap(country -> country.getCity().stream().map((city) -> {
					return city.getName();
				})).distinct().collect(Collectors.toList()));

		System.out.println("Distinct  City Count +"
				+ countryList.stream().flatMap(country -> country.getCity().stream().map((city) -> {
					return city.getName();
				})).distinct().count());

		System.out.println("Distinct official language : " + countryList.stream().flatMap((country) -> {
			return country.getLanguage().stream().filter((language) -> {
				return language.isOfficial();
			}).map((language) -> {
				return language.getLanguage();
			});
		}).collect(Collectors.toList()));

		System.out.println("Distinct official Capital City : " + countryList.stream().flatMap((country) -> {
			return country.getCity().stream().filter((city) -> {
				return city.getId() == country.getCapital();
			}).map(city -> city.getName());
		}).collect(Collectors.toList()));

		System.out.println("Distinct official Capital City count : " + countryList.stream().flatMap((country) -> {
			return country.getCity().stream().filter((city) -> {
				return city.getId() == country.getCapital();
			}).map(city -> city.getName());
		}).count());

		// Country to Contient

		System.out.println("Country to continet : " + countryList.stream()
				.collect(Collectors.groupingBy(Country::getContinent)).entrySet().stream().map((entry) -> {
					Continent continent = new Continent();
					continent.setName(entry.getKey());
					continent.setCountry(entry.getValue());
					return continent;
				}));

		System.out.println(" Average Pop by contient : " + countryList.stream().collect(
				Collectors.groupingBy(Country::getContinent, Collectors.averagingDouble(Country::getPopulation))));

		System.out
				.println(
						" Max Pop from each contient : " + countryList.stream()
								.collect(Collectors.groupingBy(Country::getContinent,
										Collectors.collectingAndThen(
												Collectors.maxBy(Comparator.comparing(Country::getPopulation)),
												Optional::get))));

		System.out.println("Summarizing Double - Min max, count, avg of pop for each continent : "
				+ countryList.stream().collect(Collectors.groupingBy(Country::getContinent,
						Collectors.summingDouble(Country::getPopulation))));

		System.out.println("First 3 Max poulatio : " + countryList.stream()
				.sorted(Comparator.comparing(Country::getPopulation).reversed()).limit(3).map(country -> {
					return country.getName() + " : " + country.getPopulation();
				}).collect(Collectors.joining(", ")));

		System.out.println("Group by Contient, Region" + countryList.stream()
				.collect(Collectors.groupingBy(Country::getContinent, Collectors.groupingBy(Country::getRegion))));

		System.out.println("==============================");
	}

}
