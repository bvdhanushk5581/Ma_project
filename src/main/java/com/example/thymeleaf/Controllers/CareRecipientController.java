package com.example.thymeleaf.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.thymeleaf.Modals.CareRecipient;
import com.example.thymeleaf.Service.CareRecipientService;

@Controller
@RequestMapping("/api")
public class CareRecipientController {
	
	private CareRecipientService emps;
	
	@Autowired
	public CareRecipientController(CareRecipientService emps) {
		this.emps=emps;
	}
	
	@GetMapping("/careRecipient")
	public String findAll(Model m){
		List<CareRecipient> careReceps = emps.findAll();
		m.addAttribute("careReceps",careReceps);
		return "careReceps/display";
	}
	
	@GetMapping("/careRecipient/{id}")
	public CareRecipient getEmployee(@PathVariable int id) {
		CareRecipient emp=emps.findById(id);
		if(emp==null) {
			return new CareRecipient();
		}
		return emp;
	}
	
	@PostMapping("/careRecipient")
	public CareRecipient saveEmployee(@RequestBody CareRecipient e) {
		e.setId(0);
		CareRecipient e1=emps.save(e);
		return e1;
	}
	
	@PutMapping("/careRecipient")
	public CareRecipient updateEmployee(@RequestBody CareRecipient e) {
		return emps.save(e);
	}
	
	@DeleteMapping("/careRecipient/{id}")
	public CareRecipient deleteEmployee(@PathVariable int id) {
		CareRecipient e = emps.findById(id);
		if(e== null) {
			return new CareRecipient();
		}
		
		return emps.deleteById(id);
	}
	
	
}
