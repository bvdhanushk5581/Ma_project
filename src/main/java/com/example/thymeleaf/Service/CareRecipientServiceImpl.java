package com.example.thymeleaf.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thymeleaf.DAO.CareRecipientDAO;
import com.example.thymeleaf.Modals.CareRecipient;

import jakarta.transaction.Transactional;

@Service
public class CareRecipientServiceImpl implements CareRecipientService{
	
private CareRecipientDAO empd;
	
	
	@Autowired
	public CareRecipientServiceImpl(CareRecipientDAO empd) {
		this.empd=empd;
	}

	@Override
	public List<CareRecipient> findAll() {
		return empd.findAll();
	}

	@Override
	public CareRecipient findById(int id) {
		return empd.findById(id);
	}

	@Transactional
	@Override
	public CareRecipient save(CareRecipient emp) {
		// TODO Auto-generated method stub
		return empd.save(emp);
	}

	@Transactional
	@Override
	public CareRecipient deleteById(int id) {
		// TODO Auto-generated method stub
		return empd.deleteById(id);
	}
	
}
