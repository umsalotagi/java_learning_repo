package com.example.photoapp.api.users.controllers;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import javax.ws.rs.core.MediaType;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.photoapp.api.users.service.UserService;
import com.example.photoapp.api.users.shared.UserDTO;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper mapper = new ModelMapper();
	
	@GetMapping("/status/check")
	public String status() {
		return "working : " + env.getProperty("local.server.port");
	}
	
	/*
	 * following is implementation done by course. issue is that. 
	 * requestDTO -> useDTO -> userEntity (persisted) -> userDTO -> responseDTO
	 * 
	 * we can directly use
	 * reuqestModel -> userEntity (persist) -> responseModel
	 */
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML},
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userDetails) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDTO user = mapper.map(userDetails, UserDTO.class);
		
		UserDTO craetedUser = userService.createUser(user);
		
		UserResponseDTO response = mapper.map(craetedUser, UserResponseDTO.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PostMapping(value = "/2", consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}, 
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ResponseEntity<UserResponseDTO> createUser2(@Valid @RequestBody UserRequestDTO userDetails) {
		UserResponseDTO response = userService.createUser(userDetails);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserResponseDTO> getUser(@PathParam("userId") Long userId) {
		
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userId));
	}
	
	

}
