package com.madlabs.rev.java8.service;

import com.madlabs.rev.java8.modal.Country;

@FunctionalInterface
public interface CountryFilter {

	public boolean filterCountry(Country country);

}
