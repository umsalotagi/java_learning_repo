package com.ds.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentDAO {
	
	@Autowired
	ComponentJdbcConnection componentJDBCConnection;

	public ComponentJdbcConnection getComponentJDBCConnection() {
		return componentJDBCConnection;
	}

	public void setComponentJDBCConnection(ComponentJdbcConnection componentJDBCConnection) {
		this.componentJDBCConnection = componentJDBCConnection;
	}

}
