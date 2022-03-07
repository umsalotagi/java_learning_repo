package com.example.app.ws.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.print.attribute.standard.MediaTray;
import javax.validation.Valid;
import javax.xml.crypto.Data;

import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.HttpResource;


@RestController
@RequestMapping("/users")
public class UIController {
	
	Map<String, User> data = new HashMap<>();
	
	
	
	//@GetMapping
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<String> getAllUsers(
			@RequestParam(value="page") int page,
			@RequestParam(value="limit", defaultValue="2") int limit,
			@RequestParam(value="sort", required=false) String sort) {
		
		// if required is given false and default value is not provided, then default is taken as null. for premitive data type, it will fail
		return new ResponseEntity<>(  page + " "+  limit + sort, HttpStatus.OK);
	}
	
	// 406 not acceptable when API does not accept media type dsent
	@GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		
		//User x = User.builder().build();
		
		//User x = new User("ok", 37, "janata", "o");
		// if exception is directly thrown withoyt @ControllerAdvice, it will be 500 internal server error
		if (data.containsKey(userId)) {
			return new ResponseEntity<>(data.get(userId), HttpStatus.OK);
		} else {
			//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			// this is necessary because in business logic level many tmes we do not have ResponseEntity as return type
			// so need to have 
			throw new UserNotFoundException(String.format("User with UUID %s does not exists", userId));
		}
		
		// if getter is not there for this object param, then error is thrown
		// Resolved [org.springframework.http.converter.HttpMessageNotWritableException: ...
		// ... No converter for [class com.example.app.ws.controller.User] with preset Content-Type 'null']
		// for APPLICATION_XML_VALUE we need jackson dependency
		
	}
	
	// spring-boot-starter-validation uses javax validation for validating request body
	// @Valid annotation needed to happen validation of requestBody data, 
	// .. so no hurdle happen when object is craeted inside from with null values
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@Valid @RequestBody UserRequestDTO user) {
		
		if (user.getName().contains("ok")) {
			throw new NullPointerException("This is null***x");
		} else if (user.getName().contains("ko")) {
			throw new NullPointerException();
		} else if (user.getName().contains("do")) {
			
		}
		
		User one = new User(user.getName(), user.getAge(), user.getAddress(), user.getEmail());
		String uid = UUID.randomUUID().toString();
		one.setUuid(uid);
		data.put(uid, one);
		return new ResponseEntity<User>(one, HttpStatus.OK);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable(value="userId") String userId, @Valid @RequestBody UpdateUserRequestDTO user) {
		User inUser = data.get(userId);
		inUser.setAge(user.getAge());
		inUser.setAddress(user.getAddress());
		return new ResponseEntity<User>(inUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable(value="userId") String uderId) {
		data.remove(uderId);
		return ResponseEntity.ok().build();
	}
	
	
	
	

}
