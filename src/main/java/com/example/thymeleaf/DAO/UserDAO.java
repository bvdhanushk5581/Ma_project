package com.example.thymeleaf.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thymeleaf.Modals.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
	
	User findByEmail (String email);

}
