package com.example.thymeleaf.Service;

import java.util.List;

import com.example.thymeleaf.Modals.CareRecipient;


public interface CareRecipientService {
	
	public List<CareRecipient> findAll();
	
	CareRecipient findById(int id);
	
	CareRecipient save(CareRecipient emp);
	
	CareRecipient deleteById(int id);
	
}
