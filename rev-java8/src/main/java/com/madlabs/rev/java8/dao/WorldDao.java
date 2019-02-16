package com.madlabs.rev.java8.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madlabs.rev.java8.modal.City;
import com.madlabs.rev.java8.modal.Country;
import com.madlabs.rev.java8.modal.Language;

@Repository
public class WorldDao {

	@Autowired
	JdbcTemplate worldJdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

	public List<Country> getWorldList() {

		return worldJdbcTemplate.query("SELECT * FROM COUNTRY", new WorldRowMapper());
	}

	public List<City> getCityList(Set<String> countryList) {

		List<String> cityLis2 = new ArrayList<String>();
		cityLis2.addAll(countryList);

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("code", cityLis2);

		return namedJdbcTemplate.query("SELECT * FROM CITY WHERE COUNTRYCODE IN (:code) ", parameters,
				new CityRowmapper());

	}

	public List<Language> getLanguageList(Set<String> countryList) {

		List<String> langList = new ArrayList<String>();
		langList.addAll(countryList);

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("code", langList);

		return namedJdbcTemplate.query("SELECT * FROM countrylanguage WHERE COUNTRYCODE IN (:code) ", parameters,
				new LanguageRowMapper());

	}

	class WorldRowMapper implements RowMapper<Country> {

		@Override
		public Country mapRow(ResultSet rs, int rowNum) throws SQLException {

			Country world = new Country();
			world.setCapital(rs.getLong("capital"));
			world.setCode(rs.getString("code"));
			world.setCode2(rs.getString("code2"));
			world.setContinent(rs.getString("continent"));
			world.setGnp(rs.getDouble("gnp"));
			world.setGnpOld(rs.getDouble("gnpOld"));
			world.setGovernmentForm(rs.getString("governmentForm"));
			world.setHeadOfState(rs.getString("headOfState"));
			world.setIndepYear(rs.getInt("indepYear"));
			world.setLifeExpectancy(rs.getDouble("lifeExpectancy"));
			world.setLocalName(rs.getString("localName"));
			world.setName(rs.getString("name"));
			world.setPopulation(rs.getLong("Population"));
			world.setSurfaceArea(rs.getString("surfaceArea"));
			world.setRegion(rs.getString("region"));

			return world;
		}

	}

	class CityRowmapper implements RowMapper<City> {

		@Override
		public City mapRow(ResultSet rs, int rowNum) throws SQLException {

			City city = new City();
			city.setDistrict(rs.getString("district"));
			city.setName(rs.getString("name"));
			city.setPopulation(rs.getLong("Population"));
			city.setCountryCode(rs.getString("CountryCode"));
			city.setId(rs.getLong("ID"));
			return city;
		}

	}

	class LanguageRowMapper implements RowMapper<Language> {

		@Override
		public Language mapRow(ResultSet rs, int rowNum) throws SQLException {
			Language language = new Language();
			language.setLanguage(rs.getString("Language"));
			language.setOfficial(rs.getString("IsOfficial").equals("T") ? true : false);
			language.setCountryCode(rs.getString("CountryCode"));
			return language;
		}
	}

}
