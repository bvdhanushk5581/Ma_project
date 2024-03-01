package com.example.thymeleaf.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.thymeleaf.Modals.CareGiver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CareGiverDAOImpl implements CareGiverDAO{
	
	private EntityManager em;
	
	@Autowired
	public CareGiverDAOImpl(EntityManager em) {
		this.em=em;
	}

	@Override
	public List<CareGiver> findAll() {
		TypedQuery<CareGiver> q=em.createQuery("from CareGiver",CareGiver.class);
		List<CareGiver>emps=q.getResultList();
		return emps;
	}

	@Override
	public CareGiver findById(int id) {
		CareGiver emp =em.find(CareGiver.class, id);
		return emp;
	}

	@Override
	public CareGiver save(CareGiver emp) {
		CareGiver empl=em.merge(emp);
		
		return empl;
	}

	@Override
	public CareGiver deleteById(int id) {
		
		CareGiver emp=em.find(CareGiver.class, id);
		
		em.remove(emp);
		
		return emp;
		
	}

}