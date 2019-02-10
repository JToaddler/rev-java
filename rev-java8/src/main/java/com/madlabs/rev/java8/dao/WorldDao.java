package com.madlabs.rev.java8.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.madlabs.rev.java8.modal.World;

@Repository
public class WorldDao {

	@Autowired
	JdbcTemplate worldJdbcTemplate;

	public List<World> getWorldList() {

		return worldJdbcTemplate.query("SELECT * FROM COUNTRY", new WorldRowMapper());
	}

	class WorldRowMapper implements RowMapper<World> {

		@Override
		public World mapRow(ResultSet rs, int rowNum) throws SQLException {

			World world = new World();
			world.setCode(rs.getString("capital"));
			world.setCode(rs.getString("code"));
			world.setCode2(rs.getString("code2"));
			world.setContinent(rs.getString("continent"));
			world.setGnp(rs.getDouble("gnp"));
			world.setGnpOld(rs.getDouble("gnpOld"));
			world.setGovernmentForm(rs.getString("governmentForm"));
			world.setHeadOfState(rs.getString("headOfState"));
			world.setIndepYear(rs.getInt("indepYear"));
			world.setLifeExpectancy(rs.getDouble("lifeExpectancy"));
			world.setCode(rs.getString("localName"));
			world.setName(rs.getString("name"));
			return world;
		}

	}

}
