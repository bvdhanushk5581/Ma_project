package com.example.thymeleaf.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.thymeleaf.Modals.Admin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class AdminDAOImpl implements AdminDAO{
private EntityManager em;
	
	@Autowired
	public AdminDAOImpl(EntityManager em) {
		this.em=em;
	}

	@Override
	public List<Admin> findAll() {
		TypedQuery<Admin> q=em.createQuery("from Admin",Admin.class);
		List<Admin>emps=q.getResultList();
		return emps;
	}
}
