package com.example.thymeleaf.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thymeleaf.DAO.QuestionsDAO;
import com.example.thymeleaf.Modals.Questions;

import jakarta.transaction.Transactional;


@Service
public class QuestionsServiceImpl implements QuestionsService{
	
	private QuestionsDAO empd;
	
	
	@Autowired
	public QuestionsServiceImpl(QuestionsDAO empd) {
		this.empd=empd;
	}

	@Override
	public List<Questions> findAll() {
		return empd.findAll();
	}

	@Override
	public Questions findById(int id) {
		return empd.findById(id);
	}

	@Transactional
	@Override
	public Questions save(Questions emp) {
		// TODO Auto-generated method stub
		return empd.save(emp);
	}

	@Transactional
	@Override
	public Questions deleteById(int id) {
		// TODO Auto-generated method stub
		return empd.deleteById(id);
	}

}
