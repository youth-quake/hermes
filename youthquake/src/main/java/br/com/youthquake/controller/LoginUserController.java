package br.com.youthquake.controller;


import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.youthquake.infra.ApplicationSecurity;
import br.com.youthquake.model.User;

@RestController
@RequestMapping("/api/login")
public class LoginUserController {

	@Autowired
	private ApplicationSecurity applicationSecurity;
	
	
	public LoginUserController(ApplicationSecurity applicationSecurity) {
		this.applicationSecurity = applicationSecurity;
	}
	
	
	// teste json
	@PostMapping(path = "/Login")
	public ResponseEntity<Response<User>> teste (@Valid @RequestBody User user, BindingResult binding){
		
		return null;
	}
	
	
	@PostMapping("/Login")
	public String loginUserRedirect(@ModelAttribute User user) {
		if(applicationSecurity.verifyUser(user)){
			return "DashboardView";
		}else{
			return "LoginView";
		}
	}
		
	@GetMapping("/Login")
	public String viewLogin(Model model){
		model.addAttribute("user",new User());
		return "LoginView";
	}
}