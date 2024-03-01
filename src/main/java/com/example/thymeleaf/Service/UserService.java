package com.example.thymeleaf.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.thymeleaf.DAO.UserDAO;
import com.example.thymeleaf.DTO.UserDTO;
import com.example.thymeleaf.Modals.User;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDAO userDAO;

	public User save(UserDTO userDto) {
		User user = new User(userDto.getUsername(),userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , userDto.getRole());
		return userDAO.save(user);
	}
	
}
