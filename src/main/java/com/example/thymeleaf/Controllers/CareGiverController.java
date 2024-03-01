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

import com.example.thymeleaf.Modals.CareGiver;
import com.example.thymeleaf.Service.CareGiverService;

@Controller
@RequestMapping("/api")
public class CareGiverController {
	
	private CareGiverService emps;
	
	@Autowired
	public CareGiverController(CareGiverService emps) {
		this.emps=emps;
	}
	
	@GetMapping("/careGiver")
	public String findAll(Model m){
		List<CareGiver> careGiver = emps.findAll();
		System.out.println(careGiver.get(0).getEmail_id());
		m.addAttribute("careGivers",careGiver);
		return "careGiver/display";
	}
	
	@GetMapping("/careGiver/{id}")
	public CareGiver getById(@PathVariable int id) {
		CareGiver emp=emps.findById(id);
		if(emp==null) {
			return new CareGiver();
		}
		return emp;
	}
	
	@PostMapping("/careGiver")
	public CareGiver insertCareGiver(@RequestBody CareGiver e) {
		e.setCare_giver_id(0);
		CareGiver e1=emps.save(e);
		return e1;
	}
	
	@PutMapping("/careGiver")
	public CareGiver updateCareGiver(@RequestBody CareGiver e) {
		return emps.save(e);
	}
	
	@DeleteMapping("/careGiver/{id}")
	public CareGiver deleteCareGiver(@PathVariable int id) {
		CareGiver e = emps.findById(id);
		if(e== null) {
			return new CareGiver();
		}
		
		return emps.deleteById(id);
	}
	
	
}
