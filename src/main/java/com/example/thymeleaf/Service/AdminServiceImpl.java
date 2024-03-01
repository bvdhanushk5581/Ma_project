package com.example.thymeleaf.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thymeleaf.DAO.AdminDAO;
import com.example.thymeleaf.Modals.Admin;

@Service
public class AdminServiceImpl implements AdminService{

private AdminDAO empd;
	
	
	@Autowired
	public AdminServiceImpl(AdminDAO empd) {
		this.empd=empd;
	}

	@Override
	public List<Admin> findAll() {
		return empd.findAll();
	}

}
