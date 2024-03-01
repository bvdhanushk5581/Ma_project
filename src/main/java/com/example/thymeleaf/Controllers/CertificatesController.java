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

import com.example.thymeleaf.Modals.Certificates;
import com.example.thymeleaf.Service.CertificateService;

@Controller
@RequestMapping("/certificates")
public class CertificatesController {
	
	private CertificateService emps;
	
	@Autowired
	public CertificatesController(CertificateService emps) {
		this.emps=emps;
	}
	
	@GetMapping("")
	public String findAll(Model m){
		List<Certificates> ques = emps.findAll();
		m.addAttribute("certificates",ques);
		return "certificates/display";
	}
	
	@GetMapping("/{id}")
	public String getCertificate(@PathVariable String id, Model m) {
		Certificates emp=emps.findUsingId(id);
		if(emp==null) {
			emp=new Certificates();
			emp.setCertificate("INVALID");
			m.addAttribute("certificates",emp);
			return "certificates/display";
		}
		m.addAttribute("certificates",emp);
		return "certificates/display";
	}
	
	@PostMapping("")
	public String saveCertificate(@RequestBody Certificates e, Model m) {
		Certificates e1=emps.save(e);
		m.addAttribute("certificates",e1);
		return "certificates/display";
	}
	
	@PutMapping("")
	public String updateCertificate(@RequestBody Certificates e, Model m) {
		Certificates q = emps.save(e);
		m.addAttribute("certificates",q);
		return "certificates/display";
	}
	
	@DeleteMapping("/{id}")
	public String deleteCertificate(@PathVariable String id, Model m) {
		Certificates e = emps.findUsingId(id);
		if(e == null) {
			return "Unable to delete";
		}
		
		Certificates q = emps.deleteUsingId(id);
		
		m.addAttribute("certificates",q);
		
		return "certificates/display";
	}
	
}
