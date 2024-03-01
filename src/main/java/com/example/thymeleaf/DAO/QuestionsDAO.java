package com.example.thymeleaf.DAO;

import java.util.List;

import com.example.thymeleaf.Modals.Questions;

public interface QuestionsDAO {

	List<Questions> findAll();
	
	Questions findById(int id);
	
	Questions save(Questions q);
	
	Questions deleteById(int id);
}
