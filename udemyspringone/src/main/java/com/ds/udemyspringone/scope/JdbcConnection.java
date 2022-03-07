package com.ds.udemyspringone.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode=ScopedProxyMode.TARGET_CLASS)
// even when scope is prototype here, different instance is not created as it is dependency of PersonDAO
// to have different instance of jdbc when we have different instance of personDAO, we need to use proxy
public class JdbcConnection {
	
	public JdbcConnection() {
		System.out.println("JDBC connection");
	}

}
