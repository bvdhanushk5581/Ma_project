package com.example.thymeleaf.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thymeleaf.DTO.UserDTO;
import com.example.thymeleaf.Modals.User;
import com.example.thymeleaf.Service.UserService;

@Controller
//@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDTO userDto, Model model) {
		System.out.println("Hellooooooooooooo");
		model.addAttribute("user", new User());
		return "register/display";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDTO userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfuly!");
		return "register/display";
	}
	
//	@PostMapping("/registration/{username}/{email}/{pass}/{role}")
//	public String saveUser(@ModelAttribute("newuser") UserDTO userDto, Model model,
//			@PathVariable("username") String username, 
//			@PathVariable("email") String email,
//			@PathVariable ("pass") String pass,
//			@PathVariable ("role") String role) {
//		
//		
//		System.out.println("Yesssssssss");
//		
//		userDto.setUsername(username);
//		userDto.setEmail(email);
//		userDto.setPassword(pass);
//		userDto.setRole(role);
//		
//		userService.save(userDto);
//		model.addAttribute("message", "Registered Successfuly!");
////		return "register";
//		return "Registered Successfuly!";
//	}
	
	@GetMapping("/login")
	public String login() {
		return "login/display";
	}
	
	@GetMapping("/careGiver-page")
	public String careGiverPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "careGiver/display";
	}
	
	@GetMapping("careRecipient-page")
	public String careRecipientPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "careReceps/display";
	}
	
	@GetMapping("admin-page")
	public String adminPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "admin/display";
	}

}