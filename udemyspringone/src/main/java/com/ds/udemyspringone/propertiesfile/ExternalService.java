package com.ds.udemyspringone.propertiesfile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExternalService {
	
	// from property file
	// Injection of autowired dependencies failed; nested exception is java.lang.IllegalArgumentException: Could not resolve placeholder 'external.service.urlk'
	@Value("${external.service.url}")
	private String url;
	@Value("${env}")
	private String env;
	
	public String getUrl() {
		return url;
	}
	public String getEnv() {
		return env;
	}

}
