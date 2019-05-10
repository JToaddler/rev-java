package com.madlabs.rev.java8.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

		List<City> cityList = worldDao.getCityList(getCountryCode(worldList));
		List<Language> langList = worldDao.getLanguageList(getCountryCode(worldList));

		return getCountry(worldList, cityList, langList);
	}

	public Set<String> getCountryCode(List<Country> countryList) {

		Set<String> countryCodes = countryList.stream().map(Country::getCode).collect(Collectors.toSet());
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
		return finalCountry;
	}
}