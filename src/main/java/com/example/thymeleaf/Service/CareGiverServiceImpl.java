package com.example.thymeleaf.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thymeleaf.DAO.CareGiverDAO;
import com.example.thymeleaf.Modals.CareGiver;

import jakarta.transaction.Transactional;

@Service
public class CareGiverServiceImpl implements CareGiverService {

private CareGiverDAO empd;
	
	
	@Autowired
	public CareGiverServiceImpl(CareGiverDAO empd) {
		this.empd=empd;
	}

	@Override
	public List<CareGiver> findAll() {
		return empd.findAll();
	}

	@Override
	public CareGiver findById(int id) {
		return empd.findById(id);
	}

	@Transactional
	@Override
	public CareGiver save(CareGiver emp) {
		// TODO Auto-generated method stub
		return empd.save(emp);
	}

	@Transactional
	@Override
	public CareGiver deleteById(int id) {
		// TODO Auto-generated method stub
		return empd.deleteById(id);
	}

}
