package com.example.thymeleaf.DAO;

import java.util.List;

import com.example.thymeleaf.Modals.Certificates;

public interface CertificateDAO {

	List<Certificates> findAll();
		
	Certificates findUsingId(String id);
		
	Certificates save(Certificates cr);
		
	Certificates deleteUsingId(String id);
}
	