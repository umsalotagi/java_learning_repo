package com.example.photoapp.api.users.service;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.photoapp.api.users.controllers.UserRequestDTO;
import com.example.photoapp.api.users.controllers.UserResponseDTO;
import com.example.photoapp.api.users.data.UserEntity;
import com.example.photoapp.api.users.data.UserRepository;
import com.example.photoapp.api.users.shared.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private ModelMapper mapper = new ModelMapper();
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public UserDTO createUser(UserDTO userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		
		// mapper will map fields from source objects to destination object (class) and create object
		// for this field name from source object to destination class.
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity ent = mapper.map(userDetails, UserEntity.class);

		log.info("before logging to.....#####.....2");
		userRepository.save(ent);
		
		UserDTO returnValue = mapper.map(ent, UserDTO.class);
		return returnValue;
	}

	@Override
	public UserResponseDTO createUser(UserRequestDTO user) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity ent = mapper.map(user, UserEntity.class);
		ent.setUserId(UUID.randomUUID().toString());
		ent.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		log.info("before logging to.....#####.....");
		userRepository.save(ent);
		
		UserResponseDTO response = mapper.map(ent, UserResponseDTO.class);
		return response;
	}

	// used for login 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByEmail(username);
		if (user==null) throw new UsernameNotFoundException(username);
		return new User(user.getEmail(), user.getEncryptedPassword(), true, true, true, true, new ArrayList<>());
	}

	@Override
	public UserDTO getUserByEmail(String email) {
		UserEntity user = userRepository.findByEmail(email);
		if (user==null) throw new UsernameNotFoundException(email);
		return new ModelMapper().map(user, UserDTO.class);
	}
	
	@Override
	public UserResponseDTO getUserById(Long id) {
		UserEntity user = userRepository.getById(id);
		if (user==null) throw new UsernameNotFoundException(id.toString());
		return mapper.map(user, UserResponseDTO.class);
	}
	
	

}
