package com.ds.udemyspringone.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class OneConfig implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Run done ");
	}
	
	@Bean
	//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public DataClass myData() {
		System.out.println("Bean created ...###################### ");
		return new DataClass("Started");
		
	}
	
	public void changeData() {
		System.out.println("Bean changed ... ");
		myData();
		
	}

}
