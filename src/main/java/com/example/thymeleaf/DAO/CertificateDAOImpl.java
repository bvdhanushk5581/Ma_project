package com.example.thymeleaf.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.thymeleaf.Modals.Certificates;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CertificateDAOImpl implements CertificateDAO {

private EntityManager em;
	
	@Autowired
	public CertificateDAOImpl(EntityManager em) {
		this.em=em;
	}

	@Override
	public List<Certificates> findAll() {
		TypedQuery<Certificates> q=em.createQuery("from Certificates",Certificates.class);
		List<Certificates>emps=q.getResultList();
		return emps;
	}

	@Override
	public Certificates findUsingId(String id) {
		Certificates emp =em.find(Certificates.class, id);
		return emp;
	}

	@Override
	public Certificates save(Certificates emp) {
		Certificates empl=em.merge(emp);
		
		return empl;
	}

	@Override
	public Certificates deleteUsingId(String id) {
		
		Certificates emp=em.find(Certificates.class, id);
		
		em.remove(emp);
		
		return emp;
		
	}

}
