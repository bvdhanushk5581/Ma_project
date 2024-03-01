package com.example.thymeleaf.DAO;

import java.util.List;

import com.example.thymeleaf.Modals.CareGiver;

public interface CareGiverDAO {
	List<CareGiver> findAll();
		
	CareGiver findById(int id);
		
	CareGiver save(CareGiver cr);
		
	CareGiver deleteById(int id);
}
