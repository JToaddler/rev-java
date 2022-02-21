package com.example.demo;

import java.util.List;

public class Continent {

	private String name;

	@Override
	public String toString() {
		return "Continent [name=" + name + ", country=" + country + "]";
	}

	private List<Country> country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Country> getCountry() {
		return country;
	}

	public void setCountry(List<Country> country) {
		this.country = country;
	}
}
