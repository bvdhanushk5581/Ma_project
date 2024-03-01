package com.example.thymeleaf.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.thymeleaf.Modals.CareRecipient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CareRecipientDAOImpl implements CareRecipientDAO{
	
	private EntityManager em;
	
	@Autowired
	public CareRecipientDAOImpl(EntityManager em) {
		this.em=em;
	}

	@Override
	public List<CareRecipient> findAll() {
		TypedQuery<CareRecipient> q=em.createQuery("from CareRecipient",CareRecipient.class);
		List<CareRecipient>emps=q.getResultList();
		return emps;
	}

	@Override
	public CareRecipient findById(int id) {
		CareRecipient emp =em.find(CareRecipient.class, id);
		return emp;
	}

	@Override
	public CareRecipient save(CareRecipient emp) {
		CareRecipient empl=em.merge(emp);
		
		return empl;
	}

	@Override
	public CareRecipient deleteById(int id) {
		
		CareRecipient emp=em.find(CareRecipient.class, id);
		
		em.remove(emp);
		
		return emp;
		
	}

}
