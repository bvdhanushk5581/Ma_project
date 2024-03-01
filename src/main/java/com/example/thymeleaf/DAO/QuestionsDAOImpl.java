package com.example.thymeleaf.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.thymeleaf.Modals.Questions;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class QuestionsDAOImpl implements QuestionsDAO{
	
private EntityManager em;
	
	@Autowired
	public QuestionsDAOImpl(EntityManager em) {
		this.em=em;
	}

	@Override
	public List<Questions> findAll() {
		TypedQuery<Questions> q=em.createQuery("from Questions",Questions.class);
		List<Questions>emps=q.getResultList();
		return emps;
	}

	@Override
	public Questions findById(int id) {
		Questions emp =em.find(Questions.class, id);
		return emp;
	}

	@Override
	public Questions save(Questions emp) {
		Questions empl=em.merge(emp);
		
		return empl;
	}

	@Override
	public Questions deleteById(int id) {
		
		Questions emp=em.find(Questions.class, id);
		
		em.remove(emp);
		
		return emp;
		
	}
}
