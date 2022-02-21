package com.example.demo;

import java.io.Serializable;

public class Language implements Serializable {
	private String countryCode;

	private boolean isOfficial;

	private String language;

	private double percentage;

	public String getCountryCode() {
		return countryCode;
	}

	public String getLanguage() {
		return language;
	}

	public double getPercentage() {
		return percentage;
	}

	public boolean isOfficial() {
		return isOfficial;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setOfficial(boolean isOfficial) {
		this.isOfficial = isOfficial;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
}
