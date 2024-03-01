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

import com.example.thymeleaf.Modals.Questions;
import com.example.thymeleaf.Service.QuestionsService;

@Controller
@RequestMapping("/questions")
public class QuestionsController {
	
	private QuestionsService emps;
		
		@Autowired
		public QuestionsController(QuestionsService emps) {
			this.emps=emps;
		}
		
		@GetMapping("")
		public String findAll(Model m){
			List<Questions> ques = emps.findAll();
			m.addAttribute("questions",ques);
			return "questions/display";
		}
		
		@GetMapping("/{id}")
		public String getQuestion(@PathVariable int id, Model m) {
			Questions emp=emps.findById(id);
			if(emp==null) {
				return "Not found";
			}
			m.addAttribute("questions",emp);
			return "questions/display";
		}
		
		@PostMapping("")
		public String saveQuestion(@RequestBody Questions e, Model m) {
			e.setQid(0);
			Questions e1=emps.save(e);
			m.addAttribute("questions",e1);
			return "questions/display";
		}
		
		@PutMapping("")
		public String updateQuestion(@RequestBody Questions e, Model m) {
			Questions q = emps.save(e);
			m.addAttribute("questions",q);
			return "questions/display";
		}
		
		@DeleteMapping("/{id}")
		public String deleteQuestion(@PathVariable int id, Model m) {
			Questions e = emps.findById(id);
			if(e== null) {
				return "Unable to delete";
			}
			
			Questions q = emps.deleteById(id);
			
			m.addAttribute("questions",q);
			
			return "questions/display";
		}
		
		
	}