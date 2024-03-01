package com.example.thymeleaf.DAO;

import java.util.List;

import com.example.thymeleaf.Modals.CareRecipient;

public interface CareRecipientDAO {
	
	List<CareRecipient> findAll();
	
	CareRecipient findById(int id);
	
	CareRecipient save(CareRecipient cr);
	
	CareRecipient deleteById(int id);
}
