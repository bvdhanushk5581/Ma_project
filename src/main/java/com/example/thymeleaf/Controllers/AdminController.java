package com.example.thymeleaf.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.thymeleaf.Modals.Admin;
import com.example.thymeleaf.Service.AdminService;

@Controller
@RequestMapping("/api")
public class AdminController {
private AdminService emps;
	
	@Autowired
	public AdminController(AdminService emps) {
		this.emps=emps;
	}
	
	@GetMapping("/admin")
	public String findAll(Model m){
		List<Admin> admins = emps.findAll();
		m.addAttribute("admins",admins);
		return "admin/display";
	}
}
