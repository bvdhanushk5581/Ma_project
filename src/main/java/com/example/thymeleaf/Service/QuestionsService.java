package com.example.thymeleaf.Service;

import java.util.List;

import com.example.thymeleaf.Modals.Questions;

public interface QuestionsService {
	
	public List<Questions> findAll();
	
	Questions findById(int id);
	
	Questions save(Questions emp);
	
	Questions deleteById(int id);
	
}
