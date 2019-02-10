package com.madlabs.rev.java8.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@ConfigurationProperties()
@Configuration
public class DaoConfig {

	@Bean(name = "worldDataSource")
	@ConfigurationProperties(prefix = "spring.hr")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "worldJdbcTemplate")
	public JdbcTemplate worldJDBCTemplate(@Qualifier("worldDataSource") DataSource ds) {

		return new JdbcTemplate(ds);

	}

}
