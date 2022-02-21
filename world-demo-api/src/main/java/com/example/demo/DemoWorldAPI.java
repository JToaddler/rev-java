package com.example.demo;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoWorldAPI {

	@RequestMapping(path = "/getAllCountry", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	private List<Country> getAllCountry(@RequestBody(required = false) Request request) {

		List<Country> countries = null;

		try {

			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("world.ser.data");
			ObjectInputStream in = new ObjectInputStream(inputStream);
			final List<Country> countryList = (List<Country>) in.readObject();
			in.close();

			if (request == null) {
				return countryList;
			}

			countries = countryList.stream().filter((country) -> {

				if (StringUtils.isNotBlank(request.getContinentName())
						&& StringUtils.isBlank(request.getCountryCode())) {
					return country.getContinent().equalsIgnoreCase(request.getContinentName());
				} else if (StringUtils.isBlank(request.getContinentName())
						&& StringUtils.isNotBlank(request.getCountryCode())) {
					return country.getCode().equalsIgnoreCase(request.getCountryCode());
				} else if (StringUtils.isNotBlank(request.getContinentName())
						&& StringUtils.isNotBlank(request.getCountryCode())) {
					return country.getCode().equalsIgnoreCase(request.getCountryCode())
							&& country.getContinent().equalsIgnoreCase(request.getContinentName());
				} else if(StringUtils.isBlank(request.getContinentName())
						&& StringUtils.isBlank(request.getCountryCode())){
					return true;
				}else
					return false;

			}).collect(Collectors.toList());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return countries;
	}

}