package com.example.thymeleaf.Service;

import java.util.List;

import com.example.thymeleaf.Modals.CareGiver;

public interface CareGiverService {
	public List<CareGiver> findAll();
		
	CareGiver findById(int id);
		
	CareGiver save(CareGiver emp);
		
	CareGiver deleteById(int id);
}
