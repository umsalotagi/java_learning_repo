package com.ds.udemyspringone.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// person data layer
@Repository  // instead of @Component, repo is used as this is data related repo. getting data from database
public class PersonDAO {
	
	// if one of dependecy is prototype we need to use proxy there, just to keep no of objects to minimum.
	@Autowired
	public JdbcConnection jdbcConnection;

	public void setJdbcConnection(JdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}

	public JdbcConnection getJdbcConnection() {
		return jdbcConnection;
	}

}
