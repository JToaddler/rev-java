package com.madlabs.rev.java8.service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madlabs.rev.java8.dao.WorldDao;
import com.madlabs.rev.java8.modal.City;
import com.madlabs.rev.java8.modal.Country;
import com.madlabs.rev.java8.modal.Language;

@Service
public class WorldService {

	@Autowired
	WorldDao worldDao;

	public List<Country> getWolrd() {

		List<Country> worldList = worldDao.getWorldList();
		System.out.println("Total Countires" + worldList.size());

		long asianCountires = worldList.stream().filter(country -> "Asia".equalsIgnoreCase(country.getContinent()))
				.count();

		long population = worldList.stream().filter(country -> "Asia".equalsIgnoreCase(country.getContinent()))
				.mapToLong(country -> country.getPopulation()).sum();

		List<Country> northAmerica = worldList.stream().filter(country -> {
			return "North America".equalsIgnoreCase(country.getContinent());
		}).collect(Collectors.toList());

		List<Country> asianList = worldList.stream().filter(country -> "Asia".equalsIgnoreCase(country.getContinent()))
				.collect(Collectors.toList());

		List<Country> result = Stream.of(asianList.stream(), northAmerica.stream()).flatMap(mapper -> {
			return mapper;
		}).collect(Collectors.toList());

		System.out.println("Flat Map result :" + result);

		System.out.println("Asian Country Count:" + asianCountires + " asias total population :" + population);

		System.out.println("Country with min population :"
				+ worldList.stream().min(Comparator.comparing(cnt -> cnt.getPopulation())).get());

		System.out.println("Country with Max population :"
				+ worldList.stream().max(Comparator.comparing(country -> country.getPopulation())).get());

		System.out.println("Distinct Country Code :" + getCountryCode(worldList));

		List<City> cityList = worldDao.getCityList(getCountryCode(worldList));
		List<Language> langList = worldDao.getLanguageList(getCountryCode(worldList));


		return getCountry(worldList, cityList, langList);
	}

	public Set<String> getCountryCode(List<Country> countryList) {

		System.out.println("country count :" + countryList);

		Set<String> countryCodes = countryList.stream().map(Country::getName).collect(Collectors.toSet());
		System.out.println(countryCodes.size());
		return countryCodes;
	}

	public List<Country> getCountry(List<Country> countryList, List<City> cityList, List<Language> languageList) {

		List<Country> finalCountry = countryList.stream().map(country -> {
			String name = country.getCode();
			country.setCity(cityList.stream().filter(city -> city.getCountryCode().equalsIgnoreCase(name))
					.collect(Collectors.toList()));
			country.setLanguage(languageList.stream().filter(lang -> name.equalsIgnoreCase(lang.getCountryCode()))
					.collect(Collectors.toList()));
			return country;
		}).collect(Collectors.toList());
		
		System.out.println(finalCountry);
		return finalCountry;
	}
}