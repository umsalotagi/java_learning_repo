package com.example.photoapp.api.users.security;

import javax.servlet.Filter;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.photoapp.api.users.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//@Autowired
	//private ApplicationContext applicationContext;
	
	@Autowired
	private AuthenticationFilter authFilter;

	// we will be using JWT token for user auth , disable cdross side request forgery
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		http.csrf().disable();
		//http.authorizeRequests().antMatchers("/users/**").permitAll();
		
		// to allow only request from spring api gateway to be accepted
		http.authorizeRequests().antMatchers("/**").hasIpAddress(env.getProperty("gateway.ip"))
		.and().addFilter(getAuthenticationFilter());
		// to make h2 console work which runs in frames
		http.headers().frameOptions().disable();
	}

	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		// following line will not work as new object will not have injected object, so get obj from app context
		//AuthenticationFilter f = new AuthenticationFilter();
		//applicationContext. to get bean, but as we are in configuration, bean we should not use 
		authFilter.setAuthenticationManager(authenticationManager());
		return authFilter;
	}
	
	// to tell the spring which service to use for getting userData and for encryption
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	
	
}
