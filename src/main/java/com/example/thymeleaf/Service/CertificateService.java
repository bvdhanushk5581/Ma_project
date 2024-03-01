package com.example.thymeleaf.Service;

import java.util.List;

import com.example.thymeleaf.Modals.Certificates;

public interface CertificateService {
	public List<Certificates> findAll();
		
	Certificates findUsingId(String id);
		
	Certificates save(Certificates emp);
		
	Certificates deleteUsingId(String id);
}
