package com.example.photoapp.api.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.photoapp.api.users.controllers.UserRequestDTO;
import com.example.photoapp.api.users.controllers.UserResponseDTO;
import com.example.photoapp.api.users.shared.UserDTO;

public interface UserService extends UserDetailsService {
	
	UserDTO createUser(UserDTO user);
	
	UserResponseDTO createUser(UserRequestDTO user);
	
	UserDTO getUserByEmail(String email);
	
	UserResponseDTO getUserById(Long id);

}
