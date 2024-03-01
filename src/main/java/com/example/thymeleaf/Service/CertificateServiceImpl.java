package com.example.thymeleaf.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thymeleaf.DAO.CertificateDAO;
import com.example.thymeleaf.Modals.Certificates;

import jakarta.transaction.Transactional;

@Service
public class CertificateServiceImpl implements CertificateService{
	
private CertificateDAO empd;
	
	
	@Autowired
	public CertificateServiceImpl(CertificateDAO empd) {
		this.empd=empd;
	}

	@Override
	public List<Certificates> findAll() {
		return empd.findAll();
	}

	
	public Certificates findUsingId(String id) {
		return empd.findUsingId(id);
	}

	@Transactional
	@Override
	public Certificates save(Certificates emp) {
		// TODO Auto-generated method stub
		return empd.save(emp);
	}

	@Transactional
	public Certificates deleteUsingId(String id) {
		// TODO Auto-generated method stub
		return empd.deleteUsingId(id);
	}
	
}
