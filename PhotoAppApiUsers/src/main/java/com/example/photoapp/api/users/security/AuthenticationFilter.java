package com.example.photoapp.api.users.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.example.photoapp.api.users.controllers.LoginRequestDTO;
import com.example.photoapp.api.users.service.UserService;
import com.example.photoapp.api.users.shared.UserDTO;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// when this filter triggered, spring fw will attempt authentication
@Component
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	@Autowired
	private UserService userService;
	
	@Value("${token.secret}")
	private String secretToken;
	
	@Value("${token.expiration_time}")
	private String expirationTime; // in milliseconds
	
	
	// this method will be called by spring framework when we send post request to /login 
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try {
			LoginRequestDTO login = new ObjectMapper().readValue(request.getInputStream(), LoginRequestDTO.class);
			return getAuthenticationManager().authenticate(
					new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword(), new ArrayList<>())
					);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new RuntimeException();
	}
	
	
	// this will run when user successfully authenticate himself
	// on successful authentication, here we can write implementation to 
	// get user detail and generate JWT token, encrypt JWT token using secret from properties file.
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String username = ((User) authResult.getPrincipal()).getUsername();
		UserDTO userdto = userService.getUserByEmail(username);
		
		System.out.println("Secret tokne and time " + expirationTime + " " + secretToken);
		
		// Generate JWT token
		String token = Jwts.builder().setSubject(userdto.getUserId()) // we might use it later on to confirm if this token belong to some userid
		.setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(expirationTime))) // time at which token will get expired
		.signWith(SignatureAlgorithm.HS512, secretToken)
		.compact();
		
		response.setHeader("token", token);
		response.addHeader("userId", userdto.getUserId());
		
	}

}
