package com.madlabs.rev.java8.modal;

import java.util.ArrayList;
import java.util.List;

public class Country {

	public long capital;
	public List<City> city;
	public List<Language> language;
	public String code;
	public String code2;
	public String continent;
	public double gnp;
	public double gnpOld;
	public String governmentForm;
	public String headOfState;

	public int indepYear;

	public double lifeExpectancy;

	public String localName;

	public String name;

	public long population;
	public String region;
	public String surfaceArea;

	public void addCity(City city) {
		if (this.city == null) {
			this.city = new ArrayList<City>();
			this.city.add(city);
		} else {
			this.city.add(city);
		}
	}

	public long getCapital() {
		return capital;
	}

	public List<City> getCity() {
		return city;
	}

	public String getCode() {
		return code;
	}

	public String getCode2() {
		return code2;
	}

	public String getContinent() {
		return continent;
	}

	public double getGnp() {
		return gnp;
	}

	public double getGnpOld() {
		return gnpOld;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public int getIndepYear() {
		return indepYear;
	}

	public double getLifeExpectancy() {
		return lifeExpectancy;
	}

	public String getLocalName() {
		return localName;
	}

	public String getName() {
		return name;
	}

	public long getPopulation() {
		return population;
	}

	public String getRegion() {
		return region;
	}

	public String getSurfaceArea() {
		return surfaceArea;
	}

	public void setCapital(long capital) {
		this.capital = capital;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public void setGnp(double gnp) {
		this.gnp = gnp;
	}

	public void setGnpOld(double gnpOld) {
		this.gnpOld = gnpOld;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public void setIndepYear(int indepYear) {
		this.indepYear = indepYear;
	}

	public void setLifeExpectancy(double lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setSurfaceArea(String surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + "]";
	}

	public List<Language> getLanguage() {
		return language;
	}

	public void setLanguage(List<Language> language) {
		this.language = language;
	}

	public void addCity(Language language) {
		if (this.language == null) {
			this.language = new ArrayList<Language>();
			this.language.add(language);
		} else {
			this.language.add(language);
		}
	}
}
