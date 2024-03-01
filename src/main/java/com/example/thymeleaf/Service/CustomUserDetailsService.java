package com.example.thymeleaf.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.thymeleaf.DAO.UserDAO;
import com.example.thymeleaf.Modals.CustomUserDetails;
import com.example.thymeleaf.Modals.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	 @Autowired
	 private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		
		return new CustomUserDetails(user);

	}

}